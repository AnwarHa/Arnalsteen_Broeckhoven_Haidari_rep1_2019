package domain;

public interface CodeStrategy {
    public String encode(String string);
    public String decode(String string);
}
