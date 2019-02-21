package domain;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Product implements Comparable<Product>{

    private String name;
    private String id;
    public Product(String name, String id) {
        this.id = id;
        setName(name);
    }

    public Product(String name) {
        this(name, null);
        setId();
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

    private void setId() {
        static final AtomicLong NEXT_ID = new AtomicLong(0);
         id= Long.toString(NEXT_ID.getAndIncrement());

    }

    public double getPrice(int days) {
        return 0;
    }
}
