package model.passageiro;

//PEDRO HENRIQUE GODRI
public class PassageiroEstudante extends Passageiro {
    
    private String escola;
    
    public PassageiroEstudante(String nome, int idade, String escola) {
        super(nome, idade);
        this.escola = escola;
    }

    @Override
    public float calcularTarifa() {
        return getTarifaInteira() / 2;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Idade: " + getIdade() + ", Escola: " + escola;
    }
}
