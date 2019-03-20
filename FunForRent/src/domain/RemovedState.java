package domain;

import java.io.Serializable;

public class RemovedState implements ArticleState, Serializable {
    private static final long serialVersionUID = 1L;
    ArticleContext articleContext;

    public RemovedState(ArticleContext articleContext) {
        this.articleContext = articleContext;
    }

}
