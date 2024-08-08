package model.viagem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.passageiro.Passageiro;

//PEDRO HENRIQUE GODRI
public abstract class Viagem {
    private List<Passageiro> passageiros;
    private String nomeMotorista;
    private String placaOnibus;
    private Date dataViagem;

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

    // Getters and setters
    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getPlacaOnibus() {
        return placaOnibus;
    }

    public void setPlacaOnibus(String placaOnibus) {
        this.placaOnibus = placaOnibus;
    }

    public Date getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(Date dataViagem) {
        this.dataViagem = dataViagem;
    }

    @Override
    public String toString() {
        return String.format("Viagem - Motorista: %s, Placa: %s, Data: %s", 
                              nomeMotorista, placaOnibus, dataViagem.toString());
    }
}
