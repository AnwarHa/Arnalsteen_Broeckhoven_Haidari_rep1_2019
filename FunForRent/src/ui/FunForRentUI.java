package ui;

import db.ArticleDB;
import domain.Article;

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

    }

    private void returnArticle() {
    }

    private void repairArticle() {
    }

    private void rentArticle() {
    }

    private void addArticle() {
        articles.addArticle(new Article(JOptionPane.showInputDialog("Article name:")));
    }

    public void removeArticle(){
        try {
            String name = JOptionPane.showInputDialog("Article name:");
            for (Map.Entry<Integer, Article> article : articles.getArticles().entrySet()) {
                if (article.getValue().getNaam().equals(name.toLowerCase().trim())) {
                    article.getValue().removeArticle();

                    articles.getArticles().remove(article.getKey());
                    break;
                }

            }
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
