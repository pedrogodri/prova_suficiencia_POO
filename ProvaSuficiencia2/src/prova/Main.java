package prova;

//PEDRO HENRIQUE GODRI
public class Main {
	public static void main(String[] args) {
		try {
            ProvaSuficiencia.serializar("src/prova/arqOrigem.txt", "src/prova/arqDestino.bin");
            System.out.println("Serialização concluída com sucesso!");
        } catch (EArquivoOrigemIncorreto e) {
            System.err.println("Erro: " + e.getMessage());
        }
	}
}
