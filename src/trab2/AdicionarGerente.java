package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdicionarGerente extends JFrame {

    private JPanel painelAdicionarGerente;
    private JPanel painelAddVendedor;
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

    public AdicionarGerente(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelAdicionarGerente);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionar();
            }
        });
    }


    public void adicionar(){

        String trg = rg.getText();
        String tnome = nome.getText();
        int tdiaNasc = Integer.parseInt(diaNasc.getText());
        int tdmesNasc = Integer.parseInt(mesNasc.getText());
        int tanoNasc = Integer.parseInt(anoNasc.getText());
        int tdiaAd = Integer.parseInt(diaAd.getText());
        int tdmesAd = Integer.parseInt(mesAd.getText());
        int tdanoAd = Integer.parseInt(anoAd.getText());
        double tsalario = Double.parseDouble(salario.getText());
       // double ttrestante = Double.parseDouble(trestante.getText());
        String tsenha = senha.getText();
        int tanosExp = Integer.parseInt(experiencia.getText());

        Gerente gerenteTemp = new Gerente(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,tanosExp,tsenha);

        try {
            //BufferedWriter saida = new BufferedWriter(new FileWriter("clientes.txt"));

            File arq = new File("gerentes.txt");
            FileWriter saida = new FileWriter(arq, true);


            String textoSaida = trg + "~"+ tnome+ "~" +tdiaNasc+ "~"+tdmesNasc + "~"+tanoNasc + "~"+tdiaAd+ "~" + tdmesAd+ "~" + tdanoAd + "~"+tsalario + "~"+tanosExp  + "~"+ tsenha+"\n";

            saida.write(textoSaida);


            saida.close();
        } catch (IOException e) {
            System.out.println("erro: " + e);
        }

        MenuGerente mg = new MenuGerente();
        close();


    }
    private void close(){
        setVisible(false);
        dispose();
    }

}