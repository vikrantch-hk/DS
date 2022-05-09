package multi.thread.aoid.deadlock;

public class LockDemo {

	/// to avoid deadlock get locks in same order in every method
	Object o1 = new Object();
	Object o2 = new Object();

	public void m1() throws InterruptedException {
		synchronized (o1) {
			System.out.println(Thread.currentThread().getName() + "  got lock on o1  ");
			Thread.sleep(10000);
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + " got lock on o2 ");
			}
			System.out.println(Thread.currentThread().getName() + " exiting lock on o2  ");
		}
		System.out.println(Thread.currentThread().getName() + " exiting lock on o1  ");
	}

	public void m2() throws InterruptedException {
		synchronized (o1) {
			System.out.println(Thread.currentThread().getName() + "  got lock on o1  ");
			Thread.sleep(10000);
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + " got lock on o2 ");
			}
			System.out.println(Thread.currentThread().getName() + " exiting lock on o2  ");
		}
		System.out.println(Thread.currentThread().getName() + " exiting lock on o1  ");
	}

}
