package thread.even.odd.oneclass;

public class PrintNumbers extends Thread {
	private volatile static boolean evenFlag = true;
	private volatile static int i = 0;
	Object lock;

	PrintNumbers(Object lock) {
		this.lock = lock;
	}

	public static void main(String ar[]) {
		Object obj = new Object();
		// This constructor is required for the identification of wait/notify
		// communication
		PrintNumbers odd = new PrintNumbers(obj);
		PrintNumbers even = new PrintNumbers(obj);
		odd.setName("Odd");
		even.setName("Even");
		even.start();
		odd.start();
	}

	@Override
	public void run() {
		while (i <= 20) {
			synchronized (lock) {
				lock.notify();
				System.out.println(i);
				i++;
				if (evenFlag == true) {
					evenFlag = false;
				} else {
					evenFlag = true;
				}
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
