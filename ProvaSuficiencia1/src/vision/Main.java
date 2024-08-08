package vision;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import model.empresa.Empresa;
import model.passageiro.Passageiro;
import model.passageiro.PassageiroEstudante;
import model.passageiro.PassageiroIdoso;
import model.passageiro.PassageiroRegular;
import model.viagem.Viagem;
import model.viagem.ViagemIntermunicipal;
import model.viagem.ViagemMunicipal;

// PEDRO HENRIQUE GODRI
public class Main extends JFrame {
    private Empresa empresa;
    private JComboBox<String> tipoViagemComboBox;
    private JTextField nomePassageiroField;
    private JTextField idadePassageiroField;
    private JComboBox<String> tipoPassageiroComboBox;
    private JComboBox<Viagem> viagemComboBox;
    private JTextArea outputArea;
    private JTextField nomeMotoristaField;
    private JTextField placaOnibusField;
    private JTextField dataViagemField;
    private JTextField escolaPassageiroField;
    private JLabel labelEscola;
    private JTextField rgPassageiroField;
    private JLabel labelRg;

    public Main() {
        empresa = new Empresa();
        setTitle("Sistema de Passageiros");
        setSize(728, 650); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        inputPanel.setBounds(0, 0, 712, 340);
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
        adicionarViagemButton.setForeground(Color.WHITE);
        adicionarViagemButton.setBackground(new Color(0, 100, 0));
        inputPanel.add(adicionarViagemButton);

        JLabel labelMotorista = new JLabel("Nome do Motorista:");
        labelMotorista.setBounds(0, 60, 150, 23);
        inputPanel.add(labelMotorista);
        nomeMotoristaField = new JTextField();
        nomeMotoristaField.setBounds(150, 60, 356, 23);
        inputPanel.add(nomeMotoristaField);

        JLabel labelPlaca = new JLabel("Placa do Ônibus:");
        labelPlaca.setBounds(0, 84, 150, 23);
        inputPanel.add(labelPlaca);
        placaOnibusField = new JTextField();
        placaOnibusField.setBounds(150, 84, 356, 23);
        inputPanel.add(placaOnibusField);

        JLabel labelData = new JLabel("Data da Viagem (dd/MM/yyyy):");
        labelData.setBounds(0, 108, 200, 23);
        inputPanel.add(labelData);
        dataViagemField = new JTextField();
        dataViagemField.setBounds(200, 108, 150, 23);
        inputPanel.add(dataViagemField);

        JLabel label_2 = new JLabel("Nome do Passageiro:");
        label_2.setBounds(0, 138, 150, 23);
        inputPanel.add(label_2);
        nomePassageiroField = new JTextField();
        nomePassageiroField.setBounds(150, 138, 356, 23);
        inputPanel.add(nomePassageiroField);

        JLabel label_3 = new JLabel("Idade do Passageiro:");
        label_3.setBounds(0, 162, 150, 23);
        inputPanel.add(label_3);
        idadePassageiroField = new JTextField();
        idadePassageiroField.setBounds(150, 162, 150, 23);
        inputPanel.add(idadePassageiroField);

        JLabel label_4 = new JLabel("Tipo de Passageiro:");
        label_4.setBounds(0, 186, 150, 23);
        inputPanel.add(label_4);
        tipoPassageiroComboBox = new JComboBox<>(new String[]{"Regular", "Estudante", "Idoso"});
        tipoPassageiroComboBox.setBounds(150, 186, 150, 23);
        inputPanel.add(tipoPassageiroComboBox);

        labelEscola = new JLabel("Escola do Estudante:");
        labelEscola.setBounds(0, 210, 150, 23);
        inputPanel.add(labelEscola);

        escolaPassageiroField = new JTextField();
        escolaPassageiroField.setBounds(150, 210, 356, 23);
        escolaPassageiroField.setVisible(false);
        inputPanel.add(escolaPassageiroField);
    
        labelRg = new JLabel("RG do Idoso:");
        labelRg.setBounds(0, 234, 150, 23);
        inputPanel.add(labelRg);

        rgPassageiroField = new JTextField();
        rgPassageiroField.setBounds(150, 234, 356, 23);
        rgPassageiroField.setVisible(false);
        inputPanel.add(rgPassageiroField);

        JLabel label_5 = new JLabel("Viagem:");
        label_5.setBounds(0, 258, 150, 23);
        inputPanel.add(label_5);
        viagemComboBox = new JComboBox<>();
        viagemComboBox.setBounds(150, 258, 356, 23);
        inputPanel.add(viagemComboBox);

        JButton adicionarPassageiroButton = new JButton("Adicionar Passageiro");
        adicionarPassageiroButton.setBounds(0, 290, 228, 23);
        adicionarPassageiroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarPassageiro();
            }
        });
        adicionarPassageiroButton.setForeground(Color.WHITE);
        adicionarPassageiroButton.setBackground(new Color(0, 100, 0));
        inputPanel.add(adicionarPassageiroButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(0, 340, 712, 217);
        getContentPane().setLayout(null);
        getContentPane().add(inputPanel);
        getContentPane().add(scrollPane);

        JButton calcularValorTotalButton = new JButton("Calcular Valor Total");
        calcularValorTotalButton.setBounds(0, 315, 228, 23);
        calcularValorTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularValorTotal();
            }
        });
        calcularValorTotalButton.setForeground(Color.WHITE);
        calcularValorTotalButton.setBackground(Color.BLUE);
        inputPanel.add(calcularValorTotalButton);

        JButton listarPassageirosMaisIdososButton = new JButton("Listar Passageiros Mais Idosos");
        listarPassageirosMaisIdososButton.setBounds(228, 315, 356, 23);
        listarPassageirosMaisIdososButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPassageirosMaisIdosos();
            }
        });
        listarPassageirosMaisIdososButton.setForeground(Color.WHITE);
        listarPassageirosMaisIdososButton.setBackground(Color.BLUE);
        inputPanel.add(listarPassageirosMaisIdososButton);

        tipoPassageiroComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarCamposVisiveis();
            }
        });
    }

    private void atualizarCamposVisiveis() {
        String tipoPassageiro = (String) tipoPassageiroComboBox.getSelectedItem();
        if ("Estudante".equals(tipoPassageiro)) {
            escolaPassageiroField.setVisible(true);
            labelEscola.setVisible(true);
            rgPassageiroField.setVisible(false);
            labelRg.setVisible(false);
        } else if ("Idoso".equals(tipoPassageiro)) {
            escolaPassageiroField.setVisible(false);
            labelEscola.setVisible(false);
            rgPassageiroField.setVisible(true);
            labelRg.setVisible(true);
        } else {
            escolaPassageiroField.setVisible(false);
            labelEscola.setVisible(false);
            rgPassageiroField.setVisible(false);
            labelRg.setVisible(false);
        }
    }

    private void adicionarViagem() {
        String tipoViagem = (String) tipoViagemComboBox.getSelectedItem();
        Viagem viagem;
        if ("Municipal".equals(tipoViagem)) {
            viagem = new ViagemMunicipal();
        } else {
            viagem = new ViagemIntermunicipal();
        }

        viagem.setNomeMotorista(nomeMotoristaField.getText());
        viagem.setPlacaOnibus(placaOnibusField.getText());
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataViagem = sdf.parse(dataViagemField.getText());
            viagem.setDataViagem(dataViagem);
        } catch (ParseException ex) {
            outputArea.append("Data inválida: " + ex.getMessage() + "\n");
            return;
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
                String escola = escolaPassageiroField.getText(); // Obtém o nome da escola
                passageiro = new PassageiroEstudante(nome, idade, escola);
            } else { // "Idoso"
                String rg = rgPassageiroField.getText(); // Obtém o RG
                passageiro = new PassageiroIdoso(nome, idade, rg);
            }

            Viagem viagem = (Viagem) viagemComboBox.getSelectedItem();
            if (viagem != null) {
                viagem.adicionarPassageiro(passageiro);
                outputArea.append("Passageiro " + nome + " adicionado à viagem.\n");
            } else {
                outputArea.append("Nenhuma viagem selecionada.\n");
            }

        } catch (Exception e) {
            outputArea.append("Erro: " + e.getMessage() + "\n");
        }
    }

    private void calcularValorTotal() {
        Viagem viagem = (Viagem) viagemComboBox.getSelectedItem();
        if (viagem != null) {
            float valorTotal = viagem.getValorTotal();
            outputArea.append("Valor total arrecadado: R$ " + valorTotal + "\n");
        } else {
            outputArea.append("Nenhuma viagem selecionada.\n");
        }
    }

    private void listarPassageirosMaisIdosos() {
        List<Passageiro> passageirosMaisIdosos = empresa.getPassageirosMaisIdosos();
        if (passageirosMaisIdosos.isEmpty()) {
            outputArea.append("Nenhum passageiro encontrado.\n");
        } else {
            for (Passageiro passageiro : passageirosMaisIdosos) {
                outputArea.append("Nome: " + passageiro.getNome() + ", Idade: " + passageiro.getIdade() + "\n");
            }
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
