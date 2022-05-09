package design.pattern.observer;

public class BinaryObserver extends Observer {
	public BinaryObserver(Observable subject) {
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("binary value now " + Integer.toBinaryString(subject.state));
	}

}
