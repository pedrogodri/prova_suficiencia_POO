package model.passageiro;

public abstract class Passageiro {
    private static final float TARIFA_INTEIRA = 5.00f;
    private String nome;
    private int idade;

    public Passageiro(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public abstract float calcularTarifa();

    public static float getTarifaInteira() {
        return TARIFA_INTEIRA;
    }
}