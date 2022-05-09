package multi.thread;

public class ThreadLocalInheritance implements Runnable {

	int i = 0;
	/*
	 * InheritableThreadLocal when a child thread is created, the child receives
	 * initial values for all inheritable thread-local variables for which the
	 * parent has values.
	 */
	InheritableThreadLocal<Integer> j = new InheritableThreadLocal<Integer>() {
		protected Integer initialValue() {
			// return super.initialValue();  returns null;
			return 0;
		};

		/*
		 * Computes the child's initial value for this inheritable thread-local
		 * variable as a function of the parent's value at the time the child
		 * thread is created
		 * if not overriden then will get parent's value
		 */
		protected Integer childValue(Integer parentValue) {
			return parentValue + 100;
		};
	};

	public void run() {
		i = i + 100;
		j.set(j.get() + 100);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("i " + i);
		System.out.println("j " + j.get());
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("child i " + i);
				System.out.println("child j " + j.get());
			}
		}).start();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runnable runnable = new ThreadLocalInheritance();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		ThreadLocalInheritance parentInstance = new ThreadLocalInheritance();
	}

}
