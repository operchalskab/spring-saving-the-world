package pl.edu.wszib.savingtheworld.dao;

import javax.persistence.*;

@Entity
@Table
public class Skladnik {


    @Id
    @GeneratedValue
    Long id;
    @OneToOne
    TypSkladnika typSkladnika;
    @Column(nullable = false)
    int ilosc;
    @ManyToOne
            @JoinColumn(name = "przepis_id")
    Przepis przepis;

    public TypSkladnika getTypSkladnika() {
        return typSkladnika;
    }

    public void setTypSkladnika(TypSkladnika typSkladnika) {
        this.typSkladnika = typSkladnika;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Przepis getPrzepis() {
        return przepis;
    }

    public void setPrzepis(Przepis przepis) {
        this.przepis = przepis;
    }
}
