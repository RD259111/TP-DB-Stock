package persistance.dao;

import java.util.List;

public interface GlobalDao<T> {

	void add(T value);

	void delete(T value);

	void update(T value);

	T findById(int id);

	List<T> findAll();
}
