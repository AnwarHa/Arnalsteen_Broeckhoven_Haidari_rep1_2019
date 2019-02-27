package domain;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Product implements Comparable<Product>{

    private String name;
    private String id;
    private boolean uitgeleend;
    public Product(String name, String id) {
        setId(id);
        setName(name);
    }

    public Product(String name) {
        this(name,null);

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
        if(id==null||id.isEmpty()) {
            this.id = Integer.toString(new Random().nextInt(2000000));

        }else{
            this.id=id;
        }

    }

    public double getPrice(int days) {
        return 0;
    }

    public void setLening(boolean uitgeleend) {
        this.uitgeleend = uitgeleend;
    }
    public boolean getLening(){
        return this.uitgeleend;
    }


}
