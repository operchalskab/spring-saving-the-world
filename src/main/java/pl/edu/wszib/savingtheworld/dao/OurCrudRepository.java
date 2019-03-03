package pl.edu.wszib.savingtheworld.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OurCrudRepository<T,ID> extends CrudRepository<T,ID> {

    @Override
    List<T> findAll();
}
