package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AdicionarCliente extends JFrame {
    private JPanel PainelAddCliente;
    private JButton close;
    private JTextField cidadetextfield;
    private JTextField bairrotextfield;
    private JTextField nruatextfield;
    private JTextField ruatextfield;
    private JTextField dependentestextfield;
    private JTextField CPFtextfield;
    private JTextField nometextfield;
    private JTextField diatextfield;
    private JLabel adicionarClienteLabel;
    private JLabel CPFLabel;
    private JLabel nomeLabel;
    private JLabel dataDeNascimentoLabel;
    private JLabel endereçoLabel;
    private JLabel ruaLabel;
    private JLabel númeroLabel;
    private JLabel bairroLabel;
    private JLabel cidadeLabel;
    private JLabel rendaLabel;
    private JLabel dependentesLabel;
    private JTextField mestextfield;
    private JTextField anotextfield;
    private JTextField rendatextfield;
    private JButton adicionarClienteButton;

    public AdicionarCliente() {
        super("Menu - Gerente");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelAddCliente);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);



        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuGerente f = new menuGerente();
                close();

            }
        });

        adicionarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adicionar();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        AdicionarCliente f = new AdicionarCliente();
    }

    public void close() {
        setVisible(false);
        dispose();
    }

    public void adicionar() throws IOException {
        int cpf = Integer.parseInt(CPFtextfield.getText());
        String nome = nometextfield.getText();
        int dia = Integer.parseInt(mestextfield.getText());
        int mes = Integer.parseInt(mestextfield.getText());
        int ano = Integer.parseInt(anotextfield.getText());

        // endereço
        String rua = ruatextfield.getText();
        int nrua = Integer.parseInt(nruatextfield.getText());
        String bairro = bairrotextfield.getText();
        String cidade = cidadetextfield.getText();
        // fim

        int renda = Integer.parseInt(rendatextfield.getText());
        int dependentes = Integer.parseInt(dependentestextfield.getText());

        //informações especificas sobre carro ou moto ainda não foram adicionadas pra eu poder comecar a testar
        Cliente clienteNovo = new Cliente(cpf, nome, dia, mes, ano, rua, nrua, bairro, cidade, renda, dependentes);


        //escreve em arquivo veiculo criado
        try {
            //BufferedWriter saida = new BufferedWriter(new FileWriter("clientes.txt"));

            File arq = new File("clientes.txt");
            FileWriter saida = new FileWriter(arq, true);


            String textoSaida = cpf + "~" + nome + "~" + dia + "~" + mes + "~" + ano + "~" + rua + "~" + nrua + "~" + bairro + "~" + cidade + "~" + renda + "~" + dependentes+"\n";
            saida.write(textoSaida);


            saida.close();
        } catch (IOException e) {
            System.out.println("erro: " + e);
        }
    }
}
