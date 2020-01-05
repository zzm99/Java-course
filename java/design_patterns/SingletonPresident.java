public class SingletonPresident
{
    public static void main(String[] args)
    {
        President zt1=President.getInstance();
        zt1.getName();    //output the name of President
        President zt2=President.getInstance();
        zt2.getName();    //output the name of President
        if(zt1==zt2)
        {
           System.out.println("They are the same person! ");
        }
        else
        {
           System.out.println("They're not the same person! ");
        }
    }
}
class President
{
    private static volatile President instance=null;    //Ensure that instance is synchronized in all threads
    //Private prevents classes from being instantiated externally
    private President()
    {
        System.out.println("Produce a President! ");
    }
    public static synchronized President getInstance()
    {
        //Synchronize on the getInstance method
        if(instance==null)
        {
               instance=new President();
        }
        else
        {
           System.out.println("There is already one President, no new President! ");
        }
        return instance;
    }
    public void getName()
    {
        System.out.println("I'm the President of the United States: Donald trump. ");
    }  
}