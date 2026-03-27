package za.ac.cput.repository;

import java.util.List;

public interface IRepository<T, ID> {

   T create(T entity);
   T read(ID id);

    T save(T t);

    T findById(ID id);

    List<T> findAll();

    T update(T t);

    boolean delete(ID id);
}