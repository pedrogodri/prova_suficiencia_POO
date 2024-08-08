package model.empresa;

//PEDRO HENRIQUE GODRI
import java.util.ArrayList;
import java.util.List;

import model.passageiro.Passageiro;
import model.viagem.Viagem;

public class Empresa {
    private List<Viagem> viagens;

    public Empresa() {
        this.viagens = new ArrayList<>();
    }

    public void adicionarViagem(Viagem viagem) {
        viagens.add(viagem);
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public List<Passageiro> getPassageirosMaisIdosos() {
        List<Passageiro> passageirosMaisIdosos = new ArrayList<>();
        int maiorIdade = 0;

        for (Viagem viagem : viagens) {
            for (Passageiro passageiro : viagem.getPassageiros()) {
                if (passageiro.getIdade() > maiorIdade) {
                    maiorIdade = passageiro.getIdade();
                    passageirosMaisIdosos.clear();
                    passageirosMaisIdosos.add(passageiro);
                } else if (passageiro.getIdade() == maiorIdade) {
                    passageirosMaisIdosos.add(passageiro);
                }
            }
        }

        return passageirosMaisIdosos;
    }
}
