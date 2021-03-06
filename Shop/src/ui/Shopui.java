package ui;

import domain.*;

import javax.swing.*;

public class Shopui {
    private Shop shop = new Shop("");

    public Shopui() {

    }

    public void showMenu() {

        String menu = "1. Add product\n2. Show products\n3. Show rental price\n4. Check availability\n\n0. Quit app";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            try {
                choice = Integer.parseInt(choiceString);
            }catch (NumberFormatException e){
                choice =-1;
            }
            switch (choice) {
                case 1:
                    addProduct(shop);
                    break;
                case 2:
                    showProducts(shop);
                    break;
                case 3:
                    showPrice(shop);
                    break;
                case 4:
                    isLent(JOptionPane.showInputDialog("Enter id:"));
                    break;
            }
        }

    }



    private void showPrice(Shop shop) {
        try {
            String name = JOptionPane.showInputDialog("Enter the name:");
            int days = Integer.parseInt(JOptionPane.showInputDialog("Enter amount of days:"));
            JOptionPane.showMessageDialog(null, "price: " + shop.getPrice(name, days));
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addProduct(Shop shop) {

        try{
            String name = JOptionPane.showInputDialog("Enter the name:");
            String soort = JOptionPane.showInputDialog("Enter the kind of product:");
            if(soort==null||soort.isEmpty()) throw new IllegalArgumentException("sort is empty");
            switch (soort.trim().toLowerCase()){
                case ("cd"): shop.addProduct(new Cd(name)); break;
                case ("movie"): shop.addProduct(new Movie(name)); break;
                case ("game"): shop.addProduct(new Game(name)); break;
                default: throw new IllegalArgumentException("sort must be cd/movie/game");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void showProducts(Shop shop){
        JOptionPane.showMessageDialog(null, shop.toString());
    }

    public void isLent(String id){
        String uit= "";
        try{
                if(!shop.getProduct(id).getLening()){ uit+=id+" is available.";}else{
            uit+=id+"is lent out.";
        }
            JOptionPane.showMessageDialog(null,uit);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

    }
}
