package ui;

import db.ArticleDB;
import domain.Article;
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
        String menu = "1. Add article\n2. Rent article\n3. Repair article\n4.Return article\n5.Remove article\n6. Show available articles\n\n0. Quit app";
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
    }

    private void showAvailableArticles() {
        ArticleState rentable = new RentableState();
        String name = askName();
        String uit = "";
        for (Map.Entry<Integer, Article> article : articles.getArticles().entrySet()) {
            if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                if(article.getValue().getCurrent().equals(rentable)){
                    uit+=article.getValue().toString();
                }
            }
        }
    }

    private void returnArticle() {
        String name = askName();
        try{
            for (Map.Entry<Integer, Article> article : articles.getArticles().entrySet()) {
                if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                    article.getValue().returnArticle();
                }
            }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,"Article can't be returned in current state");
        }
    }

    private void repairArticle() {
        String name = askName();
        try{
            for (Map.Entry<Integer, Article> article : articles.getArticles().entrySet()) {
                if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                    article.getValue().repairArticle();
                }
            }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,"Article can't be repaired in current state");
        }
    }

    private void rentArticle() {
        String name = askName();
        try{
            for (Map.Entry<Integer, Article> article : articles.getArticles().entrySet()) {
                if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                        article.getValue().rentArticle();
                }
                }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,"Article can't be rent in current state");
        }
    }

    private void addArticle() {
        try{
        articles.addArticle(new Article(JOptionPane.showInputDialog("Article name:")));
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to add the article");
        }
    }

    public void removeArticle(){

            for (Map.Entry<Integer, Article> article : articles.getArticles().entrySet()) {
                if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                    try {
                    article.getValue().removeArticle();
                    articles.getArticles().remove(article.getKey());
                    }catch (Exception e){
                        e.fillInStackTrace();
                        JOptionPane.showMessageDialog(null,"Article can't be removed in current state");
                    }
                    break;
                }

            }

    }

    public String askName(){
        String name = "";
        try {
            name = JOptionPane.showInputDialog("Article name:");
            if(name==null||name.isEmpty()){ throw new IllegalArgumentException("name is empty");}else{
                return name;
            }
        }catch (Exception e){
            e.fillInStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
