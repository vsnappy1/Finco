package framework.model;


import java.util.*;

public abstract class Subject<T> {
	private final List<Observer<T>> observers;

	public Subject() {
		observers = new ArrayList<>();
	}

	public void attach(Observer<T> observer) {
		observers.add(observer);
	}

	void detach(Observer<T> observer) {
		observers.remove(observer);
	}

	public void notify(T value) {
		for (Observer<T> observer : observers) {
			observer.update(value);
		}
	}
}
