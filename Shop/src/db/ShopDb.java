package db;

import domain.Product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopDb {
    private Map<String, Product> productMap;

    public ShopDb(){
        productMap = new HashMap<>();
    }

    public void addProduct(Product product){
        //algoritme voor ID

        productMap.put(id, product);

        //sorteer op films, games, CD's
    }

    public Map<Integer, Product> getProducten(){
        return productMap;
    }

    public List<Product> sort(){
        List<Product> sorted = new ArrayList<>();
        for(Map.Entry<String,Product> m:productMap.entrySet()){

        }
        return sorted;

    }


}
