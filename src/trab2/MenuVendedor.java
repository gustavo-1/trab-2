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
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.setSize(111,111);

        this.vendedor = v;

        NomeVendedor.setText(v.getNome());

        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irParaVender(v);
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

}
