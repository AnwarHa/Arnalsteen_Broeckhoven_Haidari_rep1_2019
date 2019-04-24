package domain;

import java.util.ArrayList;
import java.util.List;

public enum CodeAlgorithms {


    CAESARCYPHER("CaesarCypher"),MIRROR("Mirror"),VIGENERECYPHER("VigenèreCypher"),RANDOMCYPHER("RandomCypher");
    private final String name;

    private CodeAlgorithms(String name) {
        this.name = name;
    }

    public static List<String> getValueNames(){
        List<String> values = new ArrayList<>();
        for(CodeAlgorithms c : CodeAlgorithms.values()){
           values.add(c.name);
        }
        return values;
    }

    public String getName(){
        return name();
    }


}
