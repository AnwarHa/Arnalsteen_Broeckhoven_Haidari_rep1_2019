package domain;

public class CodeerContext {
    private String text;
    private CodeStrategy codeStrategy;


    public CodeerContext(){

    }

    private void setText(String text){
        this.text = text;
    }

    private void encode(){
        codeStrategy.encode(this);
    }

}
