package multi.thread;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		ThreadGroup first = new ThreadGroup("firstGrp");
		System.out.println(first.getParent().getName());
		ThreadGroup second = new ThreadGroup(first,"secndGrp");// ThreadGroup parent, String name
		System.out.println(second.getParent().getName());
		Thread t1 = new Thread(second,"t1");// (ThreadGroup group, String name)
		t1.setPriority(10);
		second.setMaxPriority(10); // affects only new threads which are going to be added to grp old thread will have same max priority
		Thread t2 = new Thread(second,"t2");
		t2.setPriority(10); 
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		t1.start();
		t2.start();
		System.out.println("first.activeCount() "+first.activeCount());
		System.out.println("second.activeCount() "+second.activeCount());// number of active threads in this thread group and its subgroups
		
		System.out.println("first.activeGroupCount() "+first.activeGroupCount());//number of active groups in this thread group 
	}

}
