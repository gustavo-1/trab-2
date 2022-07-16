package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public MenuGerente(){
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
