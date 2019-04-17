package domain;

public class GeheimschriftFactory {
    public String getEncoded(String method, String text){
        return createEncoded(method,text);
    }

    public String getDecoded(String method, String text){
        return createDecoded(method,text);
    }

    private String createEncoded(String method, String text){
        String coded = "";
        try {
            Class<?> strategy = Class.forName("ui." + method);
            Object o =strategy.getConstructor().newInstance();
            String codedText = ((CodeStrategy) o).encode(text);
            coded = codedText;

        }catch (Exception e){

        }
        return coded;
    }

    private String createDecoded(String method, String text){
        String coded = "";
        try {
            Class<?> strategy = Class.forName("ui." + method);
            Object o =strategy.getConstructor().newInstance();
            String codedText = ((CodeStrategy) o).decode(text);
            coded = codedText;

        }catch (Exception e){

        }
        return coded;
    }
}
