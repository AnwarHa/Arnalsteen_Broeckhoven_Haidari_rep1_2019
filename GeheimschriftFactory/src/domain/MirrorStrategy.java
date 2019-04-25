package domain;

public class MirrorStrategy implements CodeStrategy{
    @Override
    public String encode(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    @Override
    public String decode(String string) {
      return encode(string);
    }
}
