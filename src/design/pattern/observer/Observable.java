package design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {

	List<Observer> list = new ArrayList<Observer>();

	int state = 1;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	private void notifyAllObservers() {
		for (Observer observer : list) {
			observer.update();
		}
	}

	public void register(Observer observer)
	{
		list.add(observer);
	}
}
