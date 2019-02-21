package domain;

public class Cd extends Product {
    public Cd(String name, String id) {
        super(name);
    }

    @Override
    public double getPrice(int days) {
        return days * 1.5;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
