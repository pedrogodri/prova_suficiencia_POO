package model.viagem;

import java.util.ArrayList;
import java.util.List;

import model.passageiro.Passageiro;

public abstract class Viagem {
    private List<Passageiro> passageiros;

    public Viagem() {
        this.passageiros = new ArrayList<>();
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void adicionarPassageiro(Passageiro passageiro) throws Exception {
        if (passageiros.size() < getCapacidadeMaxima()) {
            passageiros.add(passageiro);
        } else {
            throw new Exception("Limite de passageiros excedido.");
        }
    }

    public float getValorTotal() {
        float total = 0;
        for (Passageiro passageiro : passageiros) {
            total += passageiro.calcularTarifa() + getTaxaEmbarque();
        }
        return total;
    }

    protected abstract int getCapacidadeMaxima();

    protected abstract float getTaxaEmbarque();
}