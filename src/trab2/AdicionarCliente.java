package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    private int retornar;
    private Vendedor vendedor;

    //construtor se vier de funcionario
    public AdicionarCliente(int retornar,Vendedor v) {
        super("Adicionar Cliente - Vendedor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelAddCliente);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.retornar = retornar;
        this.vendedor=v;


        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    MenuVendedor ven = new MenuVendedor(v);

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
// se vier do menu gerente
    public AdicionarCliente(int retornar) {
        super("Adicionar Cliente - Gerente");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelAddCliente);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.retornar = retornar;


        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MenuGerente mg = new MenuGerente();
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

   // public static void main(String[] args) {
       // AdicionarCliente f = new AdicionarCliente();
  // }

    public void close() {
        setVisible(false);
        dispose();
    }

    public void adicionar() throws IOException {
        int cpf = Integer.parseInt(CPFtextfield.getText());
        String nome = nometextfield.getText();
        int dia = Integer.parseInt(diatextfield.getText());
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
            System.out.println("Erro: " + e);
        }

        if(retornar ==1){ //retorna para menu gerente
            MenuGerente mg = new MenuGerente();
        }
        else{ //retorna para menu vendedor
            MenuVendedor mv = new MenuVendedor(this.vendedor);
        }

        close();

    }
}
