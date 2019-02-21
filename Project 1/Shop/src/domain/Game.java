package domain;

public class Game extends Product {
    public Game(String name, String id) {
        super(name, id);
    }

    @Override
    public double getPrice(int days) {
        return days * 3;
    }
}
