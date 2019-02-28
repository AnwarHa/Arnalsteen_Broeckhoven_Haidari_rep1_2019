package ui;

import domain.CaesarCipherStrategy;
import domain.CodeerContext;
import domain.MirrorStrategy;
import domain.VigenèreCipherStrategy;

public class Launcher {
    public static void main(String[] args) {
        CodeerContext c = new CodeerContext("waarblijftdienu");
        c.setCodeStrategy(new MirrorStrategy());
        c.encode();
        System.out.println(c.getText());
        c.decode();
        System.out.println(c.getText());
    }
}
