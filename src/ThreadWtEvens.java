public class ThreadWtEvens implements Runnable {

	private Object lock;
	public ThreadWtEvens(Object lock)
	{
		this.lock=lock;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (lock) {

			for (int i = 0; i <= 20; i += 2) {
				lock.notify();
				System.out.println(i);
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
