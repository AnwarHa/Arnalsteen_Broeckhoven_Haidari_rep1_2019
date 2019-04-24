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

    public String getText(){
        return this.text;
    }

    public void encode(String strategy){
        GeheimschriftFactory codeerFactory = new GeheimschriftFactory();
        this.text = codeerFactory.getEncoded(strategy,text);
    }

    public void decode(String strategy){
        GeheimschriftFactory codeerFactory = new GeheimschriftFactory();
        this.text = codeerFactory.getDecoded(strategy,text);
    }

}
