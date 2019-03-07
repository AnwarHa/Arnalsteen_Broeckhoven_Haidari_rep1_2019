package domain;

import java.util.Random;

public class Article {
    private String naam, id;
    private String naam;
    private RentContext rentContext;

    public Article(String naam, String id) {
        this.naam = naam;
        this.id = id;
    }

    public Article(String naam) {
        this(naam, null);
        setNaam(naam);
        rentContext = new RentContext();
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }


    private void setId(String id) {
        if (id == null || id.isEmpty()) {
            this.id = Integer.toString(new Random().nextInt(80));

        } else {
            this.id = id;
        }

    }

    public RentContext getRentContext(){
        return rentContext;
    }
}