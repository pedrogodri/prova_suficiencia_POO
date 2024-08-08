package model.passageiro;

//PEDRO HENRIQUE GODRI
public class PassageiroIdoso extends Passageiro {
	
	private String rg;
	
    public PassageiroIdoso(String nome, int idade, String rg) throws IllegalArgumentException {
        super(nome, idade);
        this.rg = rg;
        if (idade < 60) {
            throw new IllegalArgumentException("Idoso deve ter 60 anos ou mais.");
        }
    }

    @Override
    public float calcularTarifa() {
        return 0;
    }
}