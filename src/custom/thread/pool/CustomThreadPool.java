package custom.thread.pool;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import thread.pool.WorkerThread;

public class CustomThreadPool {

	BlockingQueue<Runnable> q = new LinkedBlockingQueue<Runnable>();
	SampleWorkerThread[] threads;

	public CustomThreadPool(int size) {
		this.threads = new SampleWorkerThread[size];
		for (int i = 0; i < size; i++) {
			threads[i] = new SampleWorkerThread();
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		try {
			q.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (q) {
			q.notify();
			/*
			 * we used notify() instead of notifyAll(). Because notify() has
			 * more desirable performance characteristics than notifyAll(); in
			 * particular, notify() causes many fewer context switches, which is
			 * important in a server application
			 */
		}
	}

	private class SampleWorkerThread extends Thread {
		@Override
		public void run() {
			synchronized (q) {
				while (true) {
					while (q.isEmpty()) {
						try {
							q.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try {
						Runnable task = q.take();
						System.out.println(Thread.currentThread().getName());
						task.run();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Thread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t.getName()+" "+e.getMessage());
			}
		});
		CustomThreadPool pool = new CustomThreadPool(2);
		pool.execute(() -> {
			System.out.println("running");
			try {
				Thread.sleep(10000);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		pool.execute(() -> {
			System.out.println("running");
			try {
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		pool.execute(() -> {
			System.out.println("running");
			try {
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
