package domain;

public class CodeerContext {
    private String text;
    private CodeStrategy codeStrategy;


    public CodeerContext(String text){
        setText(text);
    }

    private void setText(String text){
        this.text = text;
    }

    public void setCodeStrategy(CodeStrategy codeStrategy){
        
    }

    private void encode(){
        codeStrategy.encode(this.text);
    }

    private void decode(){
        codeStrategy.encode(this.text);
    }

}
