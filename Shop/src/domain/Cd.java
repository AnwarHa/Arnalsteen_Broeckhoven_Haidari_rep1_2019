package domain;

public class Cd extends Product {
    public Cd(String name, String id) {
        super(name);
    }
    public Cd(String name){
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

    @Override
    public String toString() {
        return super.toString()+"(CD)";
    }
}
