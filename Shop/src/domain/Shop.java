package domain;

import db.ShopDb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop{
    ShopDb productDatabase = new ShopDb();


    public Shop(String naam) {
        productDatabase.read();
    }

    public List<Product> getProducts() {
        List<Product> list = new ArrayList<Product>(productDatabase.getProductMap().values());
        return list;
    }

    public void addProduct(Product product) {
        productDatabase.addProduct(product.getId(),product);
    }

    public double getPrice(String productName, int days) {
        if(productName==null||productName.isEmpty()) throw new IllegalArgumentException("name of product is empty or doesn't exist");
        double price = 0;
        for(Product p : getProducts()){
            if(p.getName().equals(productName)){
                price = p.getPrice(days);
            }
        }
        return price;
    }

    public Product getProduct(String productName) {
        if(productName==null||productName.isEmpty()) throw new IllegalArgumentException("name of product is empty or doesn't exist");
        Product product = null;
        for(Product p : getProducts()){
            if(p.getName().equals(productName)){
                product = p;
            }
        }
        return product;
    }

    @Override
    public String toString() {
      return "Producten in shop:\n" +productDatabase.toString();
    }

    public void close(){

    }
}