package domain;

public class Game extends Product {
    public Game(String name, String id) {
        super(name);
    }
    public Game(String name){
        super(name);
    }

    @Override
    public double getPrice(int days) {
        return days * 3;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
    @Override
    public String toString() {
        return super.toString()+"(Game)";
    }
}