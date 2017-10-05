package lv.javaguru.java3.core.database;

import java.util.List;

public interface CRUDOperationDAO<E, K> {

    void create(E entity);

    E getById(K key);

    E getRequired(K key);

    void update(E entity);

    void delete(E entity);

    List<E> getAll();

}