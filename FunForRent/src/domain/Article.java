package domain;

import db.DbException;

import java.util.Random;

public class Article {
    private String naam;
    private int id;
    private ArticleState damaged, removed, rentable, returned, current;

    public Article(String naam, int id) {
        if (naam.trim().isEmpty() || naam == null) {
            throw new DbException("Naam mag niet leeg of NULL zijn !");
        }
        this.naam = naam;
        if (id == 0) {
            throw new DbException("ID mag niet 0 zijn !");
        }
        this.id = id;
        damaged = new DamagedState();
        removed = new RemovedState();
        rentable = new RentableState();
        returned = new ReturnedState();
        current = rentable;
    }

    public Article(String naam) {
        this(naam, 0);
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }


    private void setId(int id) {
        if (id == 0) {
            this.id = new Random().nextInt(80);

        } else {
            this.id = id;
        }

    }

    public int getId() {
        return id;
    }

    @Override
    public void rentArticle() {
        current

    }

    @Override
    public void repairArticle() {

    }

    @Override
    public void removeArticle() {

    }

    @Override
    public void returnArticle() {

    }


}
