package org.example.solid.voilation.lsp;

public class Penguin extends Bird {
    //Logger logger = LogManager.getLogger(Penguin.class);

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}
