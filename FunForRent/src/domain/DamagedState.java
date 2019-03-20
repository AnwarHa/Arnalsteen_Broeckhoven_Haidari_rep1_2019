package domain;

import java.io.Serializable;

public class DamagedState implements ArticleState, Serializable {
    private static final long serialVersionUID = 1L;
    ArticleContext articleContext;

    public DamagedState(ArticleContext articleContext) {
        this.articleContext = articleContext;
    }


    @Override
    public void repairArticle() {
        articleContext.setState(articleContext.getRentable());
    }

    @Override
    public void removeArticle() {
        articleContext.setState(articleContext.getRemoved());
    }

}
