package pl.edu.wszib.savingtheworld.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypSkladnikaDAO extends OurCrudRepository<TypSkladnika, Long> {

    @Override
    List<TypSkladnika>findAll();
}
