package multi.thread;

public class ThreadLocalUse implements Runnable {
	int i = 0;
	ThreadLocal<Integer> j = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 0;
		};
	};

	public void run() {
		i = i + 100;
		j.set(j.get() + 100);
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("i " + i);
		System.out.println("j " + j.get());
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runnable runnable = new ThreadLocalUse();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t1.start();
		t2.start();
		// join puts current thread in wt and current thread is main here
		t1.join();
		t2.join();
	}

}
