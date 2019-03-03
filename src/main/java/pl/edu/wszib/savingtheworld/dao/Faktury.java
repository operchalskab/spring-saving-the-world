package pl.edu.wszib.savingtheworld.dao;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Entity
@Table
public class Faktury {

    @Id
    @GeneratedValue
    Long id;

    double kwota;
    String tytuł;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "podatnik_id", nullable = false)
    Podatnik podatnik;

    public Podatnik getPodatnik() {
        return podatnik;
    }

    public void setPodatnik(Podatnik podatnik) {
        this.podatnik = podatnik;
    }

    public Faktury(){

    }
    public Faktury(double kwota, String tytuł) {
        this.kwota = kwota;
        this.tytuł = tytuł;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }


}
