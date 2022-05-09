import java.awt.print.Printable;

public class TestThread {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder strb = new StringBuilder();
		System.out.println("cap" + strb.capacity());
		Thread thread1 = new Thread(new innerThread("hello", "hw r u"));
		thread1.start();
		Thread thread2 = new Thread(new innerThread("thnx", "vry mch"));
		thread2.start();
		Thread thread3 = new Thread(new innerThread("c u", "ltr"));
		thread3.start();

	}

	private static void Print(String str1, String str2) {
		synchronized (TestThread.class) {
			System.out.println(str1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(str2);
		}

	}

	private static class innerThread implements Runnable {
		String str1, str2;

		public innerThread(String str1, String str2) {
			this.str1 = str1;
			this.str2 = str2;
		}

		public void run() {
			TestThread.Print(str1, str2);
		}

	}

}
