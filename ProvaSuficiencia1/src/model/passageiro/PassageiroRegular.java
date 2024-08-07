package model.passageiro;

public class PassageiroRegular extends Passageiro {
    public PassageiroRegular(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public float calcularTarifa() {
        return getTarifaInteira();
    }
}