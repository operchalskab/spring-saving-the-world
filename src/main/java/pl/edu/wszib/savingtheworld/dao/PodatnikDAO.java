package pl.edu.wszib.savingtheworld.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PodatnikDAO extends CrudRepository<Podatnik, Long> {

Optional<Podatnik>findByImie(String imie);

List<Podatnik>findAllByFaktury(String nazwisko);
List<Podatnik>findAll();


}
