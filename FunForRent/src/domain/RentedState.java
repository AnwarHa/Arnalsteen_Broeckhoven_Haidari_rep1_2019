package domain;

import javax.swing.*;
import java.io.Serializable;

public class RentedState implements ArticleState, Serializable {
    private static final long serialVersionUID = 1L;
    ArticleContext articleContext;

    public RentedState(ArticleContext articleContext) {
        this.articleContext = articleContext;
    }

    @Override
    public void returnArticle() {
        int res = JOptionPane.showConfirmDialog(null, "is the article damaged?", "article ", JOptionPane.YES_NO_CANCEL_OPTION);
        if( res == 0){
            articleContext.setState(articleContext.getDamaged());
        }else if(res == 1){
            articleContext.setState(articleContext.getRentable());
        }

    }
}
