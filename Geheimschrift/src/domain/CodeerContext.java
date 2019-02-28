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


    public String getText(){
        return this.text;
    }

    public void encode(){
        this.text = codeStrategy.encode(this.text);
    }

    public void decode(){
        this.text = codeStrategy.encode(this.text);
    }

}
