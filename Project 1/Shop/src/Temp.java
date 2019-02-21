/*
import javax.swing.*;
import java.util.ArrayList;

public class Tempµ {
}

import java.util.ArrayList;

        import javax.swing.JOptionPane;


public class domain.Shop {

    private ArrayList<String> productTitles;
    private ArrayList<String> productTypes;
    private ArrayList<String> productIds;

    public domain.Shop()
    {
        productTitles = new ArrayList<String>();
        productTypes = new ArrayList<String>();
        productIds = new ArrayList<String>();
    }



    public static void main(String[] args) {

    }

    public static void addProduct(domain.Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

        shop.productTitles.add(title);
        shop.productIds.add(id);
        shop.productTypes.add(type);
    }



    public static void showPrice(domain.Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");
        int idx = -1;
        boolean found = false;
        for(int i = 0; i < shop.productIds.size() && !found; i++){
            if(shop.productIds.get(i).equals(id)){
                idx = i;
                found = true;
            }
        }
        if(found){
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, shop.getPrice(idx,days));
        }
    }
}
*/
