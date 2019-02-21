package domain;

public class Cd extends Product {
    public Cd(String name, String id) {
        super(name, id);
    }

    @Override
    public double getPrice(int days) {
        return days * 1.5;
    }
}
