package domain;

public class RandomCypherStrategy implements CodeStrategy {
    @Override
    public String encode(String string) {
        return String.valueOf(new RandomCypher().encypher(string.toCharArray()));
    }

    @Override
    public String decode(String string) {
        return String.valueOf(new RandomCypher().decypher(string.toCharArray()));
    }
}
