package domain;

public class Article {
    private String naam;

    public Article(String naam) {
        setNaam(naam);
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
}
