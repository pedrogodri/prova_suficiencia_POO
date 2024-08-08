package model.viagem;

//PEDRO HENRIQUE GODRI
public class ViagemIntermunicipal extends Viagem {
    private static final int CAPACIDADE_MAXIMA = 45;
    private static final float TAXA_EMBARQUE = 3.15f;

    @Override
    protected int getCapacidadeMaxima() {
        return CAPACIDADE_MAXIMA;
    }

    @Override
    protected float getTaxaEmbarque() {
        return TAXA_EMBARQUE;
    }
}