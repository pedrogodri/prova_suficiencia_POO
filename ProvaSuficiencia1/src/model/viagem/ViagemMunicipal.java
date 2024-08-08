package model.viagem;

//PEDRO HENRIQUE GODRI
public class ViagemMunicipal extends Viagem {
    private static final int CAPACIDADE_MAXIMA = 65;

    @Override
    protected int getCapacidadeMaxima() {
        return CAPACIDADE_MAXIMA;
    }

    @Override
    protected float getTaxaEmbarque() {
        return 0;
    }
}