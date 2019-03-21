package ui;

import db.ArticleDB;
import domain.ArticleContext;
import domain.DamagedState;
import domain.DomainException;
import domain.RentableState;

import javax.swing.*;
import java.util.Map;

public class FunForRentUI {

    private ArticleDB articles;

    public FunForRentUI() {

        articles = new ArticleDB();
        showMenu();
    }

    private void showMenu() {
        String menu = "1. Add party item\n2. Rent party item\n3. Repair party item\n4. Return party item\n5. Remove party item\n6. Show available party items\n\n0. Quit app\n\nEnter choice:";
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
                    addArticle();
                    break;
                case 2:
                    rentArticle();
                    break;
                case 3:
                    repairArticle();
                    break;
                case 4:
                    returnArticle();
                    break;
                case 5:
                    removeArticle();
                    break;
                case 6:
                    showAvailableArticles();
                    break;
            }
        }
        articles.write();
    }

    private void showAvailableArticles() {
        String uit = "";

            for (Map.Entry<Integer, ArticleContext> article : articles.getArticles().entrySet()) {
                if (article.getValue().getCurrent() instanceof RentableState) {
                    uit += article.getValue().toString()+'\n';
                }
            }
        if(uit.isEmpty()){
            uit = "no articles to show";
        }
            JOptionPane.showMessageDialog(null, uit);

    }

    private void returnArticle() {
        int  id = askId();
        boolean returned = false;
        ArticleContext articleContext = null;
        try{
            for (Map.Entry<Integer, ArticleContext> article : articles.getArticles().entrySet()) {
                if (article.getKey()==id) {
                    article.getValue().returnArticle();
                    returned = true;
                    articleContext = article.getValue();
                    if(articleContext.getCurrent() instanceof DamagedState){
                        JOptionPane.showMessageDialog(null,"You succesfully returned your damaged article, repair cost= "+(articleContext.getPrijs()*5)/3);
                    }else if(articleContext.getCurrent() instanceof RentableState){
                        articleContext.setState(articleContext.getRentable());
                        JOptionPane.showMessageDialog(null,"You succesfully returned your article");
                    }
                    break;
                }
            }

            if(!returned){
            throw new DomainException("no article found with that id");
        }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void repairArticle() {
        int id = askId();
        boolean repaired = false;
        try{
            for (Map.Entry<Integer, ArticleContext> article : articles.getArticles().entrySet()) {
                if (article.getKey()==id) {
                    article.getValue().repairArticle();
                    repaired = true;
                    break;
                }
            }
            if(repaired) {
                JOptionPane.showMessageDialog(null, "Article succesfully repaired", "Succes!", JOptionPane.INFORMATION_MESSAGE);
            }else{
                throw new DomainException("no article found with that id");
            }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rentArticle() {
        int id = askId();
        boolean rent = false;
        ArticleContext articleContext = null;
        try{
            for (Map.Entry<Integer, ArticleContext> article : articles.getArticles().entrySet()) {
                if (article.getKey()==id) {
                        article.getValue().rentArticle();
                        articleContext = article.getValue();
                        rent = true;
                }
                }
            if(rent) {
                JOptionPane.showMessageDialog(null, "Article succesfully rent, cost= "+articleContext.getPrijs(), "Succes!", JOptionPane.INFORMATION_MESSAGE);
            }else{
                throw new DomainException("no article found with that id");
            }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addArticle() {
        try{
            String name = askName();
            double prijs = Double.parseDouble(JOptionPane.showInputDialog("Enter purchase price"));
        articles.addArticle(new ArticleContext(name, prijs));
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to add the article","Alert!",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void removeArticle(){
        int id = askId();
        boolean removed = false;
        try {
            for (Map.Entry<Integer, ArticleContext> article : articles.getArticles().entrySet()) {
                if (article.getKey()==id) {
                    article.getValue().removeArticle();
                    removed = true;
                    break;
                }}
                        if(removed) {
                            JOptionPane.showMessageDialog(null, "Article succesfully removed", "Succes!", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            throw new DomainException("no article found with that id");
                        }
                    }catch (Exception e){
                        e.fillInStackTrace();
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
                    }
    }

    public String askName(){
        String name = "";
        try {
            name = JOptionPane.showInputDialog("Enter the name of the article:");
            if(name==null||name.isEmpty()) throw new IllegalArgumentException("name is empty");
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }
        return name;
    }

    public int askId(){
        int id = 0;
        try {
            id =Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the article:"));
            if(id<0) throw new IllegalArgumentException("id is empty");
        }catch (Exception e){
            e.fillInStackTrace();
            throw new DomainException("invalid id");
        }
        return id;
    }
}
