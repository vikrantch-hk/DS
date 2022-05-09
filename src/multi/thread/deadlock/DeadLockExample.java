package multi.thread.deadlock;

public class DeadLockExample {
	public static void main(String[] args) {
		LockDemo s = new LockDemo();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					s.m1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					s.m2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}
}
