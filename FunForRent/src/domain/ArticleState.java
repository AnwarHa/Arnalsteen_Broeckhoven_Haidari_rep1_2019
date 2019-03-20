package domain;

public interface ArticleState {
    default void rentArticle() {
        throw new DomainException("Article can not be rent in this state");
    }

    default void repairArticle() {
        throw new DomainException("Article can not be repaired in this state");
    }

    default void removeArticle() {
        throw new DomainException("Article can not be removed in this state");
    }

    default void returnArticle() {
        throw new DomainException("Article can not be returned in this state");
    }

}
