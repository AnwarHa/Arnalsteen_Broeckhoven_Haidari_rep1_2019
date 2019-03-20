package domain;

import db.DbException;

import java.io.Serializable;
import java.util.Random;

public class ArticleContext implements Serializable {
    private static final long serialVersionUID = 1L;
    private String naam;
    private int id;
    private ArticleState damaged, removed, rentable, rented, current;

    public ArticleContext(String naam, int id) {
        if (naam.trim().isEmpty() || naam == null) {
            throw new DbException("Naam mag niet leeg of NULL zijn !");
        }
        this.naam = naam;
        setId(id);
        damaged = new DamagedState(this);
        removed = new RemovedState(this);
        rentable = new RentableState(this);
        rented = new RentedState(this);
        current = rentable;
    }

    public ArticleContext(String naam) {
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

    public void rentArticle(){
        current.rentArticle();
    }

    public void returnArticle(){
        current.returnArticle();
    }
    public void removeArticle(){
        current.removeArticle();
    }

    public void repairArticle(){
        current.repairArticle();
    }
    public void setState(ArticleState state){
        current = state;
    }
    public ArticleState getCurrent() {
        return current;
    }

    public ArticleState getDamaged() {
        return damaged;
    }

    public ArticleState getRemoved() {
        return removed;
    }

    public ArticleState getRentable() {
        return rentable;
    }

    public ArticleState getRented() {
        return rented;
    }

    @Override
    public String toString() {
        return this.id+"-"+this.naam+": "+this.current.getClass();
    }
}
