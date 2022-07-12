package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuGerente extends JFrame{

    private JPanel painelGerente;
    private JButton veiculoButton;
    private JButton clienteButton;
    private JButton funcionarioButton;
    private JButton close;
    private JComboBox opcoes; // Alterar, cadastrar, excluir
    private JTextField desempenhoseller;
    private JButton pesquisarsellerButton;

    public menuGerente(){
        super("Menu - Gerente");

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

        funcionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(opcoes.getSelectedIndex() == 0) { // Cadastrar funcionario
                    irParaAdicionarFuncionario();
                    close();
                } else if (opcoes.getSelectedIndex() == 1) { // Alterar funcionario
                    irParaAlterarFuncionario();
                    close();
                } else if (opcoes.getSelectedIndex() == 2) { // Excluir funcionario
                    irParaExcluirFuncionario();
                    close();
                }
            }
        });

        pesquisarsellerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new TelaInicialGUI("Concessionária Jose");
                close();
            }
        });

        if(opcoes.getSelectedIndex() == 0) { // Cadastrar
            System.out.println("ta selecionada a opcao 1");
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
        //AlterarVeiculo f = new AlterarVeiculo();
    }
    public void irParaExcluirVeiculo(){
        //ExcluirVeiculo f = ExcluirVeiculo();
    }

    public void irParaAdicionarCliente(){

        AdicionarCliente f = new AdicionarCliente();
    }
    public void irParaAlterarCliente(){
        //AlterarCliente f = new AlterarCliente();
    }
    public void irParaExcluirCliente(){
        //ExcluirCliente f = ExcluirCliente();
    }
    public void irParaAdicionarFuncionario(){
        // AdicionarVendedor f = new AdicionarVendedor();
    }
    public void irParaAlterarFuncionario(){
        //AlterarFuncionario f = new AlterarFuncionario();
    }
    public void irParaExcluirFuncionario(){
        //ExcluirFuncionario f = ExcluirFuncionario();
    }
}
