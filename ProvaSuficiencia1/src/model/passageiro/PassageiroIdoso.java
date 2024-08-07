package model.passageiro;

public class PassageiroIdoso extends Passageiro {
    public PassageiroIdoso(String nome, int idade) throws IllegalArgumentException {
        super(nome, idade);
        if (idade < 60) {
            throw new IllegalArgumentException("Idoso deve ter 60 anos ou mais.");
        }
    }

    @Override
    public float calcularTarifa() {
        return 0;
    }
}