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
    private Vendedor vendedor;

    public MenuVendedor(Vendedor v){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelMenuVendedor);
        this.setLocationRelativeTo(null);
        //this.setSize(111,111);
        this.pack();
        this.setVisible(true);

        this.vendedor = v;
        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irParaVender(v);
            }
        });
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarCliente ad = new AdicionarCliente(2,v);
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
}
