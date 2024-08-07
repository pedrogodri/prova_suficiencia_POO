package vision;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.empresa.Empresa;
import model.passageiro.Passageiro;
import model.passageiro.PassageiroEstudante;
import model.passageiro.PassageiroIdoso;
import model.passageiro.PassageiroRegular;
import model.viagem.Viagem;
import model.viagem.ViagemIntermunicipal;
import model.viagem.ViagemMunicipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main extends JFrame {
    private Empresa empresa;

    private JComboBox<String> tipoViagemComboBox;
    private JTextField nomePassageiroField;
    private JTextField idadePassageiroField;
    private JComboBox<String> tipoPassageiroComboBox;
    private JComboBox<Viagem> viagemComboBox;
    private JTextArea outputArea;

    public Main() {
        empresa = new Empresa();
        setTitle("Sistema de Passageiros");
        setSize(728, 577);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(0, 0, 712, 310);
        inputPanel.setLayout(null);

        JLabel label = new JLabel("Tipo de Viagem:");
        label.setBounds(0, 0, 93, 23);
        inputPanel.add(label);
        tipoViagemComboBox = new JComboBox<>(new String[]{"Municipal", "Intermunicipal"});
        tipoViagemComboBox.setBounds(94, 0, 133, 23);
        inputPanel.add(tipoViagemComboBox);

        JButton adicionarViagemButton = new JButton("Adicionar Viagem");
        adicionarViagemButton.setBounds(0, 34, 228, 23);
        adicionarViagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarViagem();
            }
        });
        inputPanel.add(adicionarViagemButton);

        JLabel label_2 = new JLabel("Nome do Passageiro:");
        label_2.setBounds(0, 104, 356, 23);
        inputPanel.add(label_2);
        nomePassageiroField = new JTextField();
        nomePassageiroField.setBounds(356, 104, 356, 23);
        inputPanel.add(nomePassageiroField);

        JLabel label_3 = new JLabel("Idade do Passageiro:");
        label_3.setBounds(0, 127, 356, 23);
        inputPanel.add(label_3);
        idadePassageiroField = new JTextField();
        idadePassageiroField.setBounds(356, 127, 356, 23);
        inputPanel.add(idadePassageiroField);

        JLabel label_4 = new JLabel("Tipo de Passageiro:");
        label_4.setBounds(0, 150, 356, 23);
        inputPanel.add(label_4);
        tipoPassageiroComboBox = new JComboBox<>(new String[]{"Regular", "Estudante", "Idoso"});
        tipoPassageiroComboBox.setBounds(356, 150, 356, 23);
        inputPanel.add(tipoPassageiroComboBox);

        JLabel label_5 = new JLabel("Viagem:");
        label_5.setBounds(0, 173, 356, 23);
        inputPanel.add(label_5);
        viagemComboBox = new JComboBox<>();
        viagemComboBox.setBounds(356, 173, 356, 23);
        inputPanel.add(viagemComboBox);

        JButton adicionarPassageiroButton = new JButton("Adicionar Passageiro");
        adicionarPassageiroButton.setBounds(0, 207, 356, 23);
        adicionarPassageiroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarPassageiro();
            }
        });
        inputPanel.add(adicionarPassageiroButton);
        JLabel label_6 = new JLabel();
        label_6.setBounds(356, 138, 356, 23);
        inputPanel.add(label_6);
        JLabel label_7 = new JLabel();
        label_7.setBounds(356, 161, 356, 23);
        inputPanel.add(label_7);
        JLabel label_8 = new JLabel();
        label_8.setBounds(356, 184, 356, 23);
        inputPanel.add(label_8);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(0, 321, 712, 217);
        getContentPane().setLayout(null);

        getContentPane().add(inputPanel);
        
                JButton calcularValorTotalButton = new JButton("Calcular Valor Total");
                calcularValorTotalButton.setBounds(0, 261, 356, 23);
                inputPanel.add(calcularValorTotalButton);
                
                        JButton listarPassageirosMaisIdososButton = new JButton("Listar Passageiros Mais Idosos");
                        listarPassageirosMaisIdososButton.setBounds(0, 287, 356, 23);
                        inputPanel.add(listarPassageirosMaisIdososButton);
                        listarPassageirosMaisIdososButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                listarPassageirosMaisIdosos();
                            }
                        });
                calcularValorTotalButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        calcularValorTotal();
                    }
                });
        getContentPane().add(scrollPane);
    }

    private void adicionarViagem() {
        String tipoViagem = (String) tipoViagemComboBox.getSelectedItem();
        Viagem viagem;
        if ("Municipal".equals(tipoViagem)) {
            viagem = new ViagemMunicipal();
        } else {
            viagem = new ViagemIntermunicipal();
        }
        empresa.adicionarViagem(viagem);
        viagemComboBox.addItem(viagem);
        outputArea.append("Viagem " + tipoViagem + " adicionada.\n");
    }

    private void adicionarPassageiro() {
        String nome = nomePassageiroField.getText();
        int idade = Integer.parseInt(idadePassageiroField.getText());
        String tipoPassageiro = (String) tipoPassageiroComboBox.getSelectedItem();
        Passageiro passageiro;

        try {
            if ("Regular".equals(tipoPassageiro)) {
                passageiro = new PassageiroRegular(nome, idade);
            } else if ("Estudante".equals(tipoPassageiro)) {
                passageiro = new PassageiroEstudante(nome, idade);
            } else {
                passageiro = new PassageiroIdoso(nome, idade);
            }

            Viagem viagem = (Viagem) viagemComboBox.getSelectedItem();
            viagem.adicionarPassageiro(passageiro);
            outputArea.append("Passageiro " + nome + " adicionado à viagem.\n");

        } catch (Exception e) {
            outputArea.append("Erro: " + e.getMessage() + "\n");
        }
    }

    private void calcularValorTotal() {
        Viagem viagem = (Viagem) viagemComboBox.getSelectedItem();
        float valorTotal = viagem.getValorTotal();
        outputArea.append("Valor total arrecadado: R$ " + valorTotal + "\n");
    }

    private void listarPassageirosMaisIdosos() {
        List<Passageiro> passageirosMaisIdosos = empresa.getPassageirosMaisIdosos();
        for (Passageiro passageiro : passageirosMaisIdosos) {
            outputArea.append("Nome: " + passageiro.getNome() + ", Idade: " + passageiro.getIdade() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main mainFrame = new Main();
                mainFrame.setVisible(true);
            }
        });
    }
}
