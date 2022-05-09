package design.pattern.observer;

public class Demo {

	public static void main(String[] args) {
		Observable subject = new Observable();
		Observer binaryObserver = new BinaryObserver(subject);
		Observer hexaObserver = new HexaObserver(subject);

		subject.setState(2);
		subject.setState(16);
	}

}
