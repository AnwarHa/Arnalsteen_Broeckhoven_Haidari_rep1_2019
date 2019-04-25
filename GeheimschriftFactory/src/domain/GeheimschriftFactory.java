package domain;

import java.net.URL;
import java.net.URLClassLoader;

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
            Class<?> strategy = Class.forName("domain." + method +"Strategy");
            Object o =strategy.getConstructor().newInstance();
            String codedText = ((CodeStrategy) o).encode(text);
            coded = codedText;

        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.fillInStackTrace());
        }
        return coded;
    }

    private String createDecoded(String method, String text){
        String decoded = "";
        try {
            Class<?> strategy = Class.forName("domain." + method +"Strategy");
            Object o =strategy.getConstructor().newInstance();
            String decodedText = ((CodeStrategy) o).decode(text);
            decoded = decodedText;

        }catch (Exception e){
            throw new RuntimeException(e.getMessage() + e.fillInStackTrace());
        }
        return decoded;
    }
}
