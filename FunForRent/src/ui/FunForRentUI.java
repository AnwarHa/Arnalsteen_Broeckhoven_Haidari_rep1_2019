package ui;

import db.ArticleDB;
import domain.ArticleContext;
import domain.ArticleState;
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
        String menu = "1. Add article\n2. Rent article\n3. Repair article\n4. Return article\n5. Remove article\n6. Show available articles\n\n0. Quit app";
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
            System.out.println(uit);
            JOptionPane.showMessageDialog(null, uit);

    }

    private void returnArticle() {
        String name = askName();
        try{
            for (Map.Entry<Integer, ArticleContext> article : articles.getArticles().entrySet()) {
                if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                    article.getValue().returnArticle();
                }
            }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void repairArticle() {
        String name = askName();
        try{
            for (Map.Entry<Integer, ArticleContext> article : articles.getArticles().entrySet()) {
                if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                    article.getValue().repairArticle();
                }
            }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rentArticle() {
        String name = askName();
        try{
            for (Map.Entry<Integer, ArticleContext> article : articles.getArticles().entrySet()) {
                if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                        article.getValue().rentArticle();
                }
                }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addArticle() {
        try{
        articles.addArticle(new ArticleContext(askName()));
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to add the article");
        }
    }

    public void removeArticle(){
        String name = askName();
            for (Map.Entry<Integer, ArticleContext> article : articles.getArticles().entrySet()) {
                if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                    try {
                    article.getValue().removeArticle();
                    }catch (Exception e){
                        e.fillInStackTrace();
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Error!",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }

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
}
