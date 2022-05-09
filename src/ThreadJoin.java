public class ThreadJoin {
	static Thread t = new Thread(new Runnable() {
		public void run() {
			// do something
		}
	});
	static Thread t1 = new Thread(new Runnable() {
		public void run() {
			// do something
		}
	});

	public static void main(String[] args) {
		t.start(); // Line 15
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Line 16
		t1.start();// Line 17
	}

	/*
	 * Hence main thread will come to line 17 only when thread t has finished.
	 * So it may appear that t.join will affect thread t1, but it is actually
	 * affecting main thread
	 */

}
