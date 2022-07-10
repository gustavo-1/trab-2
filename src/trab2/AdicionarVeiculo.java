package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarVeiculo extends JFrame {

    private JPanel painelVeiculos;
    private JButton close;
    private JButton carroButton;
    private JButton motoButton;

    public AdicionarVeiculo(){
        super("Selecionar o tipo de veículo");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelVeiculos);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        carroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irParaAdicionarCarro();
                close();
            }
        });
        motoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irParaAdicionarMoto();
                close();
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuGerente f = new menuGerente();
                close();
            }
        });
    }

    public void close(){
        setVisible(false);
        dispose();
    }
    public void irParaAdicionarCarro(){
        AdicionarCarro f = new AdicionarCarro();
    }
    public void irParaAdicionarMoto(){
        AdicionarMotocicleta f = new AdicionarMotocicleta();
    }
}
