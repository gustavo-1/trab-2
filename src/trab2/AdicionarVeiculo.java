package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarVeiculo extends JFrame {
    private JPanel painelVeiculos;
    private JButton close;
    private JButton carroButton;
    private JButton motoButton;
    private Vendedor vendedor;
    private int retornar;

    public AdicionarVeiculo(){
        super("Selecionar o tipo de veículo");
        this.retornar = 2;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelVeiculos);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        carroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarCarro f = new AdicionarCarro();
                close();
            }
        });
        motoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarMotocicleta f = new AdicionarMotocicleta();
                close();
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGerente f = new MenuGerente();
                close();
            }
        });
    }
    ///veio do vendedor
    public AdicionarVeiculo(int retornar, Vendedor v){
        super("Selecionar o tipo de veículo");
        this.vendedor = v;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelVeiculos);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        carroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarCarro f = new AdicionarCarro(1,vendedor);
                close();
            }
        });
        motoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarMotocicleta f = new AdicionarMotocicleta(1,vendedor);
                close();
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuVendedor f = new MenuVendedor(v);
                close();
            }
        });
    }

    public void close(){
        setVisible(false);
        dispose();
    }

}
