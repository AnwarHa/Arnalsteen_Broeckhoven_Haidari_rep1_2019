package ui;

import domain.*;

import javax.swing.*;

public class Shopui {
    private Shop shop = new Shop("");

    public Shopui(Shop shop) {

        showMenu();
    }

    private void showMenu() {
        String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                addProduct(shop);
            } else if (choice == 2) {
                showProduct(shop);
            } else if (choice == 3){
                showPrice(shop);
            }
        }
    }



    private void showPrice(Shop shop) {
        String name = JOptionPane.showInputDialog("Enter the id:");
        int days = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        JOptionPane.showMessageDialog(null, "price: " +shop.getPrice(name,days) );
    }

    private void addProduct(Shop shop) {
        String name = JOptionPane.showInputDialog("Enter the id:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String soort = JOptionPane.showInputDialog("Enter the kind of product:");
        Product p = null;
        try{
            if(soort==null||soort.isEmpty()) throw new IllegalArgumentException("sort is invalid");
            switch (soort.trim().toLowerCase()){
                case ("cd"): p = new Cd(name,id);
                case ("movie"): p = new Movie(name,id);
                case ("game"): p = new Game(name,id);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage() );
        }
    }

    public static void showProduct(Shop shop){
        String name = JOptionPane.showInputDialog("Enter the name:");

        JOptionPane.showMessageDialog(null, shop.getProduct(name));

    }
}
