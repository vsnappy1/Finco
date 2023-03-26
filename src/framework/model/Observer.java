package framework.model;

public interface Observer<T> {
	void update(T value);
}
