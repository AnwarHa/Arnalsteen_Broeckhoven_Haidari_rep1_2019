package domain;

public abstract class Product implements Comparable<Product>{
    private String name;
    private String id;
    public Product(String name, String id) {
        setId(id);
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public double getPrice(int days) {
        return 0;
    }
}
