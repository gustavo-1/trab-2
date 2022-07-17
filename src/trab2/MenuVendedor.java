package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuVendedor extends JFrame {

    private JPanel painelMenuVendedor;
    private JButton close;
    private JComboBox opcoes;
    private JButton veiculoButton;
    private JButton clienteButton;
    private JButton venderButton;
    private JLabel NomeVendedor;
    private Vendedor vendedor;

    public MenuVendedor(Vendedor v){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelMenuVendedor);
        this.setLocationRelativeTo(null);
        //this.setSize(111,111);
        this.pack();
        this.setVisible(true);

        this.vendedor = v;

        NomeVendedor.setText(v.getNome());

        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                irParaVender(v);
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

        veiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(opcoes.getSelectedIndex() == 0) { // Cadastrar gerente
                    irParaAdicionarVeiculo();
                    close();
                } else if (opcoes.getSelectedIndex() == 1) { // Alterar gerente
                    irParaAlterarVeiculo();
                    close();
                } else if (opcoes.getSelectedIndex() == 2) { // Excluir gerente
                    irParaExcluirVeiculo();
                    close();
                }
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaInicialGUI ti = new TelaInicialGUI("José Motors");
                close();
            }
        });
    }


    void irParaVender(Vendedor v){
        MenuVender ve = new MenuVender(v);
        close();
    }

    private void close(){
        setVisible(false);
        dispose();
    }
    public void irParaAdicionarVeiculo(){
        AdicionarVeiculo f = new AdicionarVeiculo(1,this.vendedor);
    }
    public void irParaAlterarVeiculo(){
        AlterarVeiculo f = new AlterarVeiculo(1, this.vendedor);
    }
    public void irParaExcluirVeiculo(){
        ExcluirVeiculo rc = new ExcluirVeiculo(1,this.vendedor);
    }

    public void irParaAdicionarCliente(){

        AdicionarCliente f = new AdicionarCliente(1,this.vendedor);
    }
    public void irParaAlterarCliente(){
        AlterarCliente f = new AlterarCliente(1, this.vendedor);
    }
    public void irParaExcluirCliente(){
        ExcluirCliente f = new ExcluirCliente(1,this.vendedor);
    }
    public void irParaAdicionarFuncionario(){
        AdicionarVendedor f = new AdicionarVendedor(1, this.vendedor);
    }
    public void irParaAlterarFuncionario(){
        AlterarVendedor f = new AlterarVendedor(1, this.vendedor);
    }
    public void irParaExcluirFuncionario(){
        ExcluirVendedor f = new ExcluirVendedor(1, this.vendedor);
    }
    public void irParaAdicionarGerente(){
        //AdicionarGerente a = new AdicionarGerente();
    }
    public void irParaAlterarGerente(){

    }
    public void irParaExcluirGerente(){

    }
}
