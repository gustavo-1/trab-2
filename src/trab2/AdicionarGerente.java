package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdicionarGerente extends JFrame {

    private JPanel painelAdicionarGerente;
    private JPanel painelAddGerente;
    private JTextField rg;
    private JTextField nome;
    private JTextField anoNasc;
    private JTextField salario;
    private JTextField diaNasc;
    private JTextField mesNasc;
    private JButton button1;
    private JTextField mesAd;
    private JTextField diaAd;
    private JTextField anoAd;
    private JTextField senha;
    private JButton close;
    private JTextField experiencia;
    private JLabel erroEntrada;

    public AdicionarGerente(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelAdicionarGerente);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGerente mg = new MenuGerente();
                close();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionar();
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MenuGerente mg = new MenuGerente();
                close();
            }
        });
    }
    private void closewindow(){
        setVisible(false);
        dispose();
    }

    public void adicionar(){
        try{

        String trg = rg.getText();
        String tnome = nome.getText();
        int tdiaNasc = Integer.parseInt(diaNasc.getText());
        int tdmesNasc = Integer.parseInt(mesNasc.getText());
        int tanoNasc = Integer.parseInt(anoNasc.getText());
        int tdiaAd = Integer.parseInt(diaAd.getText());
        int tdmesAd = Integer.parseInt(mesAd.getText());
        int tdanoAd = Integer.parseInt(anoAd.getText());
        double tsalario = Double.parseDouble(salario.getText());
        String tsenha = senha.getText();
        int tanosExp = Integer.parseInt(experiencia.getText());

        Gerente gerenteTemp = new Gerente(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,tanosExp,tsenha);

        try {
            File arq = new File("gerentes.txt");
            FileWriter saida = new FileWriter(arq, true);

            String textoSaida = trg + "~"+ tnome+ "~" +tdiaNasc+ "~"+tdmesNasc + "~"+tanoNasc + "~"+tdiaAd+ "~" + tdmesAd+ "~" + tdanoAd + "~"+tsalario + "~"+tanosExp  + "~"+ tsenha+"\n";

            saida.write(textoSaida);
            saida.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

        MenuGerente mg = new MenuGerente();
        close();
        }catch (Exception e){
            erroEntrada.setVisible(true);
            System.out.println("--------------------------------erro-----------------------------"+e);
        }
    }
    private void close(){
        setVisible(false);
        dispose();
    }

}
