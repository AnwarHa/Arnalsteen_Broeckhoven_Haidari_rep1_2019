package db;

import domain.Cd;
import domain.Game;
import domain.Movie;
import domain.Product;

import java.io.*;
import java.io.FileOutputStream;
import java.util.*;

public class ShopDb {
    private Map<String, Product> productMap;
    private String path;
    File productFile;

    public ShopDb() {
        productMap = new HashMap<>();
        path ="C:\\Users\\Kalimath\\Documents\\products.txt";
        productFile = new File(path);
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void addProduct(String id, Product product) {
        if (product != null) {
            productMap.put(id, product);
            write();
        } else {
            throw new db.DbException("Product is null");
        }

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
            FileOutputStream fileOut = new FileOutputStream(productFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(uit);
            objectOut.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void read() {

        try {

            Scanner scannerFile = new Scanner(productFile);
            while (scannerFile.hasNextLine()) {
                Scanner scannerLijn = new Scanner(scannerFile.nextLine());
                Product product =null;
                String uid = scannerLijn.next();
                scannerLijn.useDelimiter(",");
                System.out.println(uid);
                String instance = scannerLijn.next();
                String name = scannerLijn.next();
                switch (instance){
                    case ("cd"): product = new Cd(name,uid); break;
                    case ("movie"): product = new Movie(name,uid); break;
                    case ("game"): product = new Game(name,uid); break;
                }
                productMap.put(uid,product);
            }
        } catch (Exception e) {
            throw new DbException("Fout bij het inlezen: "+e.getMessage());
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


        @Override
        public String toString() {
            String uit = "";
        if(!productMap.isEmpty()) {

            for (Map.Entry<String, Product> m : getProductMap().entrySet()) {
                String instance = "";
                if (m.getValue() instanceof Cd) instance = "(cd)";
                if (m.getValue() instanceof Movie) instance = "(movie)";
                if (m.getValue() instanceof Game) instance = "(game)";
                uit += m.getKey() + ": " + m.getValue().getName() + " " + instance;
            }
        }else{
            uit+= "No products yet";
        }
            return uit;
        }

}
