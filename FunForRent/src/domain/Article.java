package domain;

import db.DbException;

import java.util.Random;

public class Article {
    private String naam, id;
    private RentContext rentContext;

    public Article(String naam, String id) {
        if(naam.trim().isEmpty() || naam == null){
            throw new DbException("Naam mag niet leeg of NULL zijn !");
        }
        this.naam = naam;
        this.id = id;
        rentContext = new RentContext();
    }

    public Article(String naam) {
        this(naam, null);
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

    public String getId() {
        return id;
    }

    public RentContext getRentContext(){
        return rentContext;
    }
}
