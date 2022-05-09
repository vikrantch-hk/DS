package multi.thread.deadlock;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class LockDemo {

	Object o1 = new Object();
	Object o2 = new Object();

	public void m1() throws InterruptedException {
		synchronized (o1) {
			System.out.println(Thread.currentThread().getName() + " got lock on o1 ");
			Thread.sleep(2000);
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + " got lock on o2 ");
			}
			System.out.println(Thread.currentThread().getName() + " exiting lock on o2  ");
		}
		System.out.println(Thread.currentThread().getName() + " exiting lock on o1  ");
	}

	public void m2() throws InterruptedException {
		synchronized (o2) {
			System.out.println(Thread.currentThread().getName() + " got lock on o2 ");
			Thread.sleep(2000);
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName() + " got lock on o1 ");
			}
			System.out.println(Thread.currentThread().getName() + " exiting lock on o1  ");
		}
		System.out.println(Thread.currentThread().getName() + " exiting lock on o2  ");
	}
}
