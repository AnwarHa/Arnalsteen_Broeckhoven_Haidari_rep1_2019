package domain;

public class CodeerContext {
    private String text;
    private CodeStrategy codeStrategy;


    public CodeerContext(String text){
        setText(text);
    }

    private void setText(String text){
        if (text == null){
            throw new IllegalArgumentException("text cannot be null");
        }
        this.text = text;
    }

    public void setCodeStrategy(CodeStrategy codeStrategy){
        if(codeStrategy==null) throw new IllegalArgumentException("code method is empty");
        this.codeStrategy = codeStrategy;
    }



    private void encode(){
        codeStrategy.encode(this.text);
    }

    private  void decode(){
        codeStrategy.encode(this.text);
    }

}
