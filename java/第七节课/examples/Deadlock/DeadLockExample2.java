package test6;

public class DeadLockExample2 implements Runnable {

	// 两个静态的资源
	public static Object obj1 = new Object();
	public static Object obj2 = new Object();
	// 标志位
	public int flag = 1; // 1 or 2
	
	@Override
	public void run() {

		if (flag == 1) {
			synchronized (obj1) {
				System.out.println("flag: " + flag + ", 锁住了资源obj1");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("flag: " + flag + ", 等待获取资源obj2");
				synchronized (obj2) {
					System.out.println("flag: " + flag + ", 获得资源obj2");
				}
			}
		} else if (flag == 2) {
			synchronized (obj2) {
				System.out.println("flag: " + flag + ", 锁住了资源obj2");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("flag: " + flag + ", 等待获取资源obj1");
				synchronized (obj1) {
					System.out.println("flag: " + flag + ", 获得资源obj1");
				}
			}
		}
	}

	public static void main(String[] args) {

		DeadLockExample2 p1 = new DeadLockExample2();
		DeadLockExample2 p2 = new DeadLockExample2();
		p1.flag = 1;
		p2.flag = 2;

		new Thread(p1).start();
		new Thread(p2).start();

	}

}