package db;

import domain.Product;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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

    public boolean write(){
        String uit = "\n";
        for(Map.Entry<String,Product> m:productMap.entrySet()){
            uit+= m.getKey()+","+m.getValue().getName();
        }
        try {
            FileOutputStream fileOut = new FileOutputStream(".\\Documents\\products.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(uit);
            objectOut.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


}
