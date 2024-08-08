package prova;

import java.io.*;
import java.nio.file.*;
import java.util.*;

//PEDRO HENRIQUE GODRI
public class ProvaSuficiencia {

    public static void serializar(String arqOrigem, String arqDestino) throws EArquivoOrigemIncorreto {
        Set<Atleta> atletas = new TreeSet<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(arqOrigem))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dados = line.split(",");
                if (dados.length != 10 && dados.length != 9) {
                    throw new EArquivoOrigemIncorreto("Formato do arquivo de origem incorreto.");
                }
                String nome = dados[0];
                String cpf = dados[1];
                float altura = Float.parseFloat(dados[2]);
                float peso = Float.parseFloat(dados[3]);
                String rua = dados[4];
                String numero = dados[5];
                String complemento = dados.length == 10 ? dados[6] : "";
                String cep = dados.length == 10 ? dados[7] : dados[6];
                String cidade = dados.length == 10 ? dados[8] : dados[7];
                String estado = dados.length == 10 ? dados[9] : dados[8];

                Endereco endereco = new Endereco(rua, numero, complemento, cep, cidade, estado);
                Atleta atleta = new Atleta(nome, cpf, altura, peso, endereco);
                atletas.add(atleta);
            }
        } catch (IOException e) {
            throw new EArquivoOrigemIncorreto("Erro ao ler o arquivo de origem: " + e.getMessage());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arqDestino))) {
            oos.writeObject(atletas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}