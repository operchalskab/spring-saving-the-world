package pl.edu.wszib.savingtheworld;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.savingtheworld.dao.Faktury;
import pl.edu.wszib.savingtheworld.dao.FakturyDAO;
import pl.edu.wszib.savingtheworld.dao.Podatnik;
import pl.edu.wszib.savingtheworld.dao.PodatnikDAO;
import pl.edu.wszib.savingtheworld.dto.PodatnikDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/podatnik")
public class PodatnikController {

    @Autowired
    PodatnikDAO dao;
    @Autowired
    Mapper mapper;
    @Autowired
    FakturyDAO fakturr;

    @GetMapping
    public PodatnikDTO podatnik(@RequestParam Long pesel) {
        //  return dao.findById(pesel).orElse(null);
        return dao.findById(pesel).map(podatnik -> mapper.map(podatnik, PodatnikDTO.class)).orElse(null);

    }

    @GetMapping("/all")
    public List<PodatnikDTO> podatnicy() {
        return StreamSupport.stream(dao.findAll().spliterator(), false).map(podatnik -> mapper.map(podatnik, PodatnikDTO.class)).collect(Collectors.toList());

    }

    @PostMapping
    public PodatnikDTO zapisz(@RequestBody PodatnikDTO podatnik) {
        return mapper.map(dao.save(mapper.map(podatnik, Podatnik.class)), PodatnikDTO.class);

    }

    @DeleteMapping
    public PodatnikDTO usun(@RequestParam Long pesel) {
        Podatnik podatnik = dao.findById(pesel).orElse(null);
        dao.deleteById(pesel);
        return mapper.map(podatnik, PodatnikDTO.class);

    }

    @GetMapping("/faktury")
    public Page<Faktury> faktury(@RequestParam Long peselPodatnika, @RequestParam int strona, @RequestParam int rozmiar) {
return fakturr.findAllByPodatnikPesel(peselPodatnika, PageRequest.of(strona,rozmiar));


    }
}