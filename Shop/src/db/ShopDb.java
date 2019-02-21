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

    public void addProduct(String id, Product product) {
        //algoritme voor ID

        if (product != null) {

            productMap.put(id, product);
        } else {
            throw new db.DbException("Product is null");
        }

        //sorteer op films, games, CD's
    }

    public List<Product> sort() {
        final List<String> sorted = productMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        // or to specify the list implementation:
        //.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

// Output
        sorted.forEach(System.out::println);

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
        if (productMap.containsKey(id) && productMap.get(id).getLening() == false) {
            return true;
        }
        return false;
    }

    public void setProductOpUitgeleend(String id){
        if (productMap.get(id) != null){
            productMap.get(id).setLening(true);
        }

    }
}
