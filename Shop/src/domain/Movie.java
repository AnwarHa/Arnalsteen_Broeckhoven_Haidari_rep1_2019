package domain;

public class Movie extends Product{
    public Movie(String name, String id) {
        super(name);
    }

    @Override
    public double getPrice(int days){
        double price = 0;
            price = 5;
            int daysLeft = days - 3;
            if (daysLeft > 0) {
                price += (daysLeft * 2);
            }
        return price;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
