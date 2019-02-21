package db;

import domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ShopDb {
    private Map<Integer, Product> productMap;

    public ShopDb(){
        productMap = new HashMap<>();
    }

    public void addProduct(int id,Product product){
        //algoritme voor ID

        productMap.put(id, product);

        //sorteer op films, games, CD's
    }

    public Map<Integer, Product> getProducten(){
        return productMap;
    }
}
