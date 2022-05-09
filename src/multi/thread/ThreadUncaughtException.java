package multi.thread;

import java.lang.Thread.UncaughtExceptionHandler;

// to handle runtime exception in thread setUncaughtExceptionHandler
public class ThreadUncaughtException {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				//t.setUncaughtExceptionHandler();
				Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

					@Override
					public void uncaughtException(Thread t, Throwable e) {
						System.out.println(t.getName());
						System.out.println(e);
						System.out.println(t.getState());

					}
				});
				System.out.println(Integer.parseInt("1"));
				System.out.println(Integer.parseInt("one"));
				System.out.println(Integer.parseInt("2"));
				System.out.println(Integer.parseInt("3"));

			}
		});

		t.start();
	}

}
