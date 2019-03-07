package db;

import domain.Article;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ArticleDB {
    private Map<Integer, Article> articleHashMap;

    private String path;

    public ArticleDB() {
        articleHashMap = new HashMap<>();
        path ="C:\\Users\\Kalimath\\Desktop\\test.txt";
    }

    public void addArticle(Article a) {
        if (a != null) {
            articleHashMap.put(a.getId(), a);
            write();
        } else {
            throw new db.DbException("Product is null");
        }
    }

    public void write() {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(articleHashMap);
            objectOut.close();
            System.out.println("The "+articleHashMap.getClass()  +" was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void read() {

        try {

            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            this.articleHashMap = (Map<Integer, Article>) objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public Map<Integer, Article> getArticles(){
        return this.articleHashMap;
    }
    
}
