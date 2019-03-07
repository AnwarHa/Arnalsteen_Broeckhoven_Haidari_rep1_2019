package domain;

public interface ArticleState {
    default void rentArticle() {
        throw new DomainException("Rent Article Default");
    }

    default void repairArticle() {
        throw new DomainException("Repair Article Default");
    }

    default void removeArticle() {
        throw new DomainException("Remove Article Default");
    }

    default void returnArticle() {
        throw new DomainException("Return Article Default");
    }

}
