package db;

import domain.Product;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

    public Map<Integer, Product> getProducten() {
        return productMap;
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
            uit += m.getKey() + "," + m.getValue().getName();
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
