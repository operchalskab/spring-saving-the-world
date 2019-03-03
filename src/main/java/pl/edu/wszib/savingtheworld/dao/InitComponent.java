package pl.edu.wszib.savingtheworld.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class InitComponent {

    @Autowired
    PodatnikDAO podatnikDAO;

    @Autowired
    FakturyDAO fakturyDAO;

    @PostConstruct
    public void init(){

        //List<Faktury>wszystkie = fakturyDAO.findAll();

        IntStream.range(0,10).forEach(i -> {

            Podatnik podatnik = new Podatnik("Adam" + i , "Adam" + i);
          //  podatnik.setFaktury(Arrays.asList(wszystkie.get(i % 10), wszystkie.get((i+5) %10)));
           // podatnik = podatnikDAO.save(podatnik);
          //  podatnik.getImie();
            Podatnik podatnikSaved=podatnikDAO.save(podatnik);


        IntStream.range(0,1000).forEach(j->{
            Faktury faktury = new Faktury(3.5,"cos" + i);
            // faktury = fakturyDAO.save(faktury);
            faktury.setPodatnik(podatnikSaved);
            faktury = fakturyDAO.save(faktury);

        });
        });

        System.out.println("");
}

        //podatnik.getImie();



    @PreDestroy
    public void teardown(){

    }
}
