package design.pattern.observer;

public abstract class Observer {

	Observable subject;
	
	public Observer(Observable subject) {
		super();
		this.subject = subject;
		this.subject.register(this);
	}

	public abstract void update();

}
