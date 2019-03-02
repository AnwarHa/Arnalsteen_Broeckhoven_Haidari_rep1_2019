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
        Product[] sorted = new Product[unsorted.size()];
        for(int i=0; i<unsorted.size()-1;i++){
           sorted[i] = unsorted.get(i);
        }
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

    private void write() {
        String uit = "\n";
        for (Map.Entry<String, Product> m : productMap.entrySet()) {
            String instance = "";
            if (m.getValue() instanceof Cd) instance = "cd";
            if (m.getValue() instanceof Movie) instance = "movie";
            if (m.getValue() instanceof Game) instance = "game";
            uit += instance + "," + m.getKey() + "," + m.getValue().getName()+"\n";
        }
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(uit);
            objectOut.close();
            System.out.println("The "+uit.getClass()  +" was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void read() {

        try {
            File txt = new File(path);
            Scanner scannerFile = new Scanner(txt);
            while (scannerFile.hasNextLine()) {

                Product product = null;
                String uid = Integer.toString(scannerFile.nextInt());
                scannerFile.useDelimiter(",");
                System.out.println(uid);
                String instance = scannerFile.next();
                String name = scannerFile.next();
                switch (instance) {
                    case ("cd"):
                        product = new Cd(name, uid);
                        break;
                    case ("movie"):
                        product = new Movie(name, uid);
                        break;
                    case ("game"):
                        product = new Game(name, uid);
                        break;
                }
                productMap.put(uid, product);
            }
        } catch (Exception e) {
            throw new DbException("Fout bij het inlezen: "+e.getMessage()+e.fillInStackTrace());
        }

    }
        @Override
        public String toString() {
            String uit = "";
        if(!productMap.isEmpty()) {

            for (Map.Entry<String, Product> m : productMap.entrySet()) {
                uit+=m.getValue().toString();

            }
            //with sort algorithm, like this:
            /*for (Product m : this.sort()) {
                uit+=m.toString();

            }*/
        }else{
            uit+= "No products yet";
        }
            return uit;
        }

}
