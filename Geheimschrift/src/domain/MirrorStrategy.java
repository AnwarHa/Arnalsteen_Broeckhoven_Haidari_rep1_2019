package domain;

public class MirrorStrategy implements CodeStrategy{
    @Override
    public String encode(String string) {
        byte [] stringAsBytes = string.getBytes();
        byte [] result = new byte[stringAsBytes.length];

        for(int i = 0; i<stringAsBytes.length; i++){
            result[i] = stringAsBytes[stringAsBytes.length - i - 1];
        }
        return new String(result);
    }

    @Override
    public String decode(String string) {
      return encode(string);
    }
}
