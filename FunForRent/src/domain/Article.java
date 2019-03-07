package domain;

public class Article {
    private String naam;
    private RentContext rentContext;


    public Article(String naam) {
        setNaam(naam);
        rentContext = new RentContext();
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public RentContext getRentContext(){
        return rentContext;
    }
}
