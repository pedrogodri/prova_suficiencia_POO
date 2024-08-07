package prova;

import java.io.Serializable;

public class Atleta implements Serializable, Comparable<Atleta> {
    private String nome;
    private String cpf;
    private float altura;
    private float peso;
    private Endereco endereco;

    public Atleta(String nome, String cpf, float altura, float peso, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.altura = altura;
        this.peso = peso;
        this.endereco = endereco;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public int compareTo(Atleta other) {
        return this.cpf.compareTo(other.cpf);
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", endereco=" + endereco +
                '}';
    }
}