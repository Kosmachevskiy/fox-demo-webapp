package app.persistence;

import java.util.Collection;

public interface Dao<T> {

    Collection<T> getAll();

    T save(T entity);
}
