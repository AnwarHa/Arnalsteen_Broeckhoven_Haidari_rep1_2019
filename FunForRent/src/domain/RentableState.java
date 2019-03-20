package domain;

import javax.swing.*;
import java.io.Serializable;

public class RentableState implements ArticleState, Serializable {
    private static final long serialVersionUID = 1L;
    ArticleContext articleContext;

    public RentableState(ArticleContext articleContext) {
        this.articleContext = articleContext;
    }
    @Override
    public void rentArticle() {
        articleContext.setState(articleContext.getRented());
    }

    @Override
    public void removeArticle() {
        articleContext.setState(articleContext.getRemoved());

    }
}
