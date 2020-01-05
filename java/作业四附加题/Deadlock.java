package Deadlock;

class MEN extends Thread{
    private String name;
    private Fork cur;
    public MEN(String name,Fork cur){
        super(name);
        this.name=name;
        this.cur=cur;
    }
    
    public void run(){
        while(true){
            thinking();
            cur.tryTodo();
            eating();
            cur.OverDo();
        }
    }
    
    public void eating(){
        System.out.println(name + " is eating.");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    public void thinking(){
        System.out.println(name + " is thinking.");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Fork{
    private boolean[] flag = {false,false,false,false,false,false};
    
    public synchronized void tryTodo(){
        int i = Thread.currentThread().getName().charAt(3)-'0';
        int a = i, b = i+1; 
        if(b == 6) b = 1;
        while(flag[a]||flag[b]){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag[a]=true;  flag[b]=true;
    }
    
    public synchronized void OverDo(){
        int i = Thread.currentThread().getName().charAt(3)-'0';
        int a = i, b = i+1; 
        if(b == 6) b = 1;
        flag[a]=false;  flag[b]=false;
        System.out.println(Thread.currentThread().getName() + " is over eating.");
        notifyAll();
    }
}


public class Deadlock {
    public static void main(String []args){
        Fork cur = new Fork();
        // 1 2 3 4 5 -> 1
        for(int i=1; i<=5; i++)
        	new MEN("men" + i, cur).start();
    }
}