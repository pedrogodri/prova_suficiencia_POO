package model.passageiro;

public class PassageiroEstudante extends Passageiro {
    public PassageiroEstudante(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public float calcularTarifa() {
        return getTarifaInteira() / 2;
    }
}