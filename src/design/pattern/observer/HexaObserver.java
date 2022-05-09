package design.pattern.observer;

public class HexaObserver extends Observer {
	public HexaObserver(Observable subject) {
		super(subject);
	}

	@Override
	public void update() {
		System.out.println("hexa value now " + Integer.toHexString(subject.state));
	}

}
