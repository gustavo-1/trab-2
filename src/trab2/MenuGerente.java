package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuGerente extends JFrame{

    private JPanel painelGerente;
    private JButton veiculoButton;
    private JButton clienteButton;
    private JButton vendedorButton;
    private JButton close;
    private JComboBox opcoes; // Alterar, cadastrar, excluir
    private JTextField desempenhoseller;
    private JButton pesquisarsellerButton;
    private JButton gerenteButton;
    private Vendedor vendedor;

    static List<DesempenhoVendedor> listaDesempenho= new ArrayList<DesempenhoVendedor>();

    public MenuGerente(){
        super("Menu - Gerente");
        ler();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelGerente);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        veiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(opcoes.getSelectedIndex() == 0) { // Cadastrar veiculo
                    irParaAdicionarVeiculo();
                    close();
                } else if(opcoes.getSelectedIndex() == 1) { // Alterar veiculo
                    irParaAlterarVeiculo();
                    close();
                } else if(opcoes.getSelectedIndex() == 2) { // Excluir veiculo
                    irParaExcluirVeiculo();
                    close();
                }
            }
        });
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(opcoes.getSelectedIndex() == 0) { // Cadastrar cliente
                    irParaAdicionarCliente();
                    close();
                } else if (opcoes.getSelectedIndex() == 1) { // Alterar cliente
                    irParaAlterarCliente();
                    close();
                } else if (opcoes.getSelectedIndex() == 2) { // Excluir cliente
                    irParaExcluirCliente();
                    close();
                }
            }
        });

        vendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(opcoes.getSelectedIndex() == 0) { // Cadastrar funcionario
                    irParaAdicionarVendedor();
                    close();
                } else if (opcoes.getSelectedIndex() == 1) { // Alterar funcionario
                    irParaAlterarVendedor();
                    close();
                } else if (opcoes.getSelectedIndex() == 2) { // Excluir funcionario
                    irParaExcluirVendedor();
                    close();
                }
            }
        });

        pesquisarsellerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     Desempenho d = new Desempenho(desempenhoseller.getText());
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new TelaInicialGUI("Concessionária José");
                close();
            }
        });

        gerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(opcoes.getSelectedIndex() == 0) { // Cadastrar gerente
                    irParaAdicionarGerente();
                    close();
                } else if (opcoes.getSelectedIndex() == 1) { // Alterar gerente
                    irParaAlterarGerente();
                    close();
                } else if (opcoes.getSelectedIndex() == 2) { // Excluir gerente
                    irParaExcluirGerente();
                    close();
                }
            }
        });
    }

    public void ler(){

        //ler vendedor
        try{
            File arq = new File("vendas.txt");
            Scanner myReader = new Scanner(arq);
            //BufferedReader leitor = new BufferedReader(arq);

            Vendedor tempVendedor;

            while(myReader.hasNextLine()){

                String leitura = myReader.nextLine();
                System.out.println("Leitura: \n" + leitura);

                String[] atributos = leitura.split("~");

                int tid = Integer.parseInt(atributos[0]);
                String nomeseller = atributos[1];
                String tipoVeiculo = atributos[2];
                int cpf = Integer.parseInt(atributos[2]);
                String tipoPagamento = atributos[10];

                for(String s: atributos){
                    System.out.println("atributos:\n"+s);
                }
                Vendedor vendedor = this.vendedor;

                DesempenhoVendedor tempDesempenho = new DesempenhoVendedor(tid, nomeseller, cpf, tipoVeiculo, tipoPagamento);
                listaDesempenho.add(tempDesempenho);

            }
            myReader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }
    }

    private void close(){
        setVisible(false);
        dispose();
    }
    public void irParaAdicionarVeiculo(){
        AdicionarVeiculo f = new AdicionarVeiculo();
    }
    public void irParaAlterarVeiculo(){
        AlterarVeiculo f = new AlterarVeiculo();
    }
    public void irParaExcluirVeiculo(){
        ExcluirVeiculo rc = new ExcluirVeiculo();
    }

    public void irParaAdicionarCliente(){

        AdicionarCliente f = new AdicionarCliente(1);
    }
    public void irParaAlterarCliente(){
        AlterarCliente f = new AlterarCliente();
    }
    public void irParaExcluirCliente(){
        ExcluirCliente f = new ExcluirCliente();
    }
    public void irParaAdicionarVendedor(){
         AdicionarVendedor f = new AdicionarVendedor();
    }
    public void irParaAlterarVendedor(){
        AlterarVendedor f = new AlterarVendedor();
    }
    public void irParaExcluirVendedor(){
        ExcluirVendedor f = new ExcluirVendedor();
    }
    public void irParaAdicionarGerente(){
        AdicionarGerente a = new AdicionarGerente();
    }
    public void irParaAlterarGerente(){
        AlterarGerente ag = new AlterarGerente();
    }
    public void irParaExcluirGerente(){
            ExcluirGerente eg = new ExcluirGerente();
    }
}
