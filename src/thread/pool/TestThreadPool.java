package thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThreadPool implements Callable<String> {
	public static void main(String[] args) {
		Executors.newCachedThreadPool();// Creates a thread pool that creates
										// new threads as needed, but will reuse
										// previously constructed threads when
										// they are available.
		Executors.newScheduledThreadPool(5).schedule(new Callable<String>() {
				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					return "";
				}
			}, 1, TimeUnit.SECONDS);// Creates a thread pool that can
											// schedule commands to run after a
											// given delay, or to execute
											// periodically
		Executors.newWorkStealingPool();// Creates a work-stealing thread pool
										// using all available processors as its
										// target parallelism level.
		ExecutorService executor = Executors.newFixedThreadPool(5);// creating a
																	// pool of 5
																	// threads
		ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);// calling execute method of
										// ExecutorService
			executor2.schedule(worker, 5, TimeUnit.SECONDS);
			Future<String> future = executor.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					return "";
				}
			});

			if (future.isDone())// Returns true if this task completed.
								// Completion may be due to normal termination,
								// an exception, or cancellation -- in all of
								// these cases, this method will return true.
				try {
					future.get();// Waits if necessary for the computation to
									// complete, and then retrieves its result.

				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");
	}

	public static <T> void print(T t) {
		System.out.println(t);
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
