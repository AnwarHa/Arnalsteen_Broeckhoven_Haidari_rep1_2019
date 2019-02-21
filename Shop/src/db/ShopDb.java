package db;

import domain.Cd;
import domain.Game;
import domain.Movie;
import domain.Product;

import java.io.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

public class ShopDb {
    private Map<String, Product> productMap;

    public ShopDb() {
        productMap = new HashMap<>();
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void addProduct(Product product) {
        //algoritme voor ID
        int id = 0;
        if (product != null) {
            id = productMap.size() + 1;
        }

        String sid = "" + id;

        productMap.put(sid, product);

        //sorteer op films, games, CD's
    }

    public List<Product> sort() {

        List<Product> unsorted = new ArrayList<>(productMap.values());
        Product[] sorted = (Product[]) unsorted.toArray();
        for(int i=0; i<sorted.length-1;i++){
            if(Integer.parseInt(sorted[i].getId())>Integer.parseInt(sorted[i+1].getId())){
                Product min = sorted[i];
                Product more = sorted[i+1];
                sorted[i] = more;
                sorted[i+1] = min;
            }
        }
        List<Product> sol = new ArrayList<>();
        for(int i=0; i<sorted.length-1;i++){
            sol.add(i,sorted[i]);
        }
        return sol;
    }

    public boolean write() {
        String uit = "\n";
        for (Map.Entry<String, Product> m : productMap.entrySet()) {
            String instance = "";
            if (m.getValue() instanceof Cd) instance = "cd";
            if (m.getValue() instanceof Movie) instance = "movie";
            if (m.getValue() instanceof Game) instance = "game";
            uit += instance + "," + m.getKey() + "," + m.getValue().getName();
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

    public boolean isProductBeschikbaar(String id) {
        if (productMap.containsKey(id)) {
            return true;
        }
        return false;
    }


}
