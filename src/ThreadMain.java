public class ThreadMain{


	static int i=1,j=2;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new innerThread("even"));
		t1.start();
		Thread t2 = new Thread(new innerThread("odd"));
		t2.start();
	}
	public static void print(int k) {
		
		
		synchronized (ThreadMain.class) {
			while (k <= 20) {

				System.out.println(k);
				try {
					Thread.sleep(1000);
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				k+=2;
			}
		}
	}

	
	
	private static class innerThread implements Runnable{
		private String str;
		public innerThread(String str) {
			// TODO Auto-generated constructor stub
			this.str=str;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(str.equals("even"))
				print(i);
			if(str.equals("odd"))
				print(j);
		}
	}

}
