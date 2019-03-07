package domain;

import java.util.HashMap;

public class ArticleDB {
    private HashMap<Integer, Article> articleHashMap = new HashMap<>();

    public ArticleDB() {

    }

    public void voegArticleToe(int i, Article a) {
        if (a != null) {
            articleHashMap.put(i, a);
        }
    }
    
}
