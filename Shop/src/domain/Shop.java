package domain;

import db.ShopDb;

import java.util.ArrayList;
import java.util.List;

public class Shop{
    ShopDb productDatabase = new ShopDb();

    public Shop(String naam) {

    }

    public List<Product> getProducts() {
        return productDatabase;
    }

    public void addProduct(Product product) {
        productDatabase.add(product);
    }

    public double getPrice(String productName, int days) {
        if(productName==null||productName.isEmpty()) throw new IllegalArgumentException("name of product is empty or doesn't exist");
        double price = 0;
        for(Product p : productDatabase){
            if(p.getName().equals(productName)){
                price = p.getPrice(days);
            }
        }
        return price;
    }

    public Product getProduct(String productName) {
        if(productName==null||productName.isEmpty()) throw new IllegalArgumentException("name of product is empty or doesn't exist");
        Product product = null;
        for(Product p : productDatabase){
            if(p.getName().equals(productName)){
                product = p;
            }
        }
        return product;
    }

    public void close(){

    }
}