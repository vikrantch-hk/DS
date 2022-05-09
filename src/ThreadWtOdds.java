
public class ThreadWtOdds implements Runnable {
	private Object lock;
	public ThreadWtOdds(Object lock)
	{
		this.lock=lock;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (lock) {

			for (int i = 1; i <= 19; i += 2) {
				lock.notify();
				System.out.println(i);
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			lock.notify();
		}

	}

}
