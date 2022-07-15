package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdicionarVendedor extends JFrame{
    private JPanel painelAddVendedor;
    private JTextField rg;
    private JTextField nome;
    private JTextField anoNasc;
    private JTextField mesAd;
    private JTextField salario;
    private JTextField diaNasc;
    private JTextField mesNasc;
    private JTextField trestante;
    private JComboBox gerente;
    private JButton button1;
    private JTextField diaAd;
    private JTextField anoAd;
    private JTextField senha;
    private JButton close;

    public AdicionarVendedor(){
        super("Adicionar Funcionario");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelAddVendedor);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVendedor();
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MenuGerente menuGerente = new MenuGerente();
                close();

            }
        });

    }

   // public static void main(String[] args) {
      //  AdicionarVendedor a = new AdicionarVendedor();
   // }
    public void adicionarVendedor(){
        String trg = rg.getText();
        String tnome = nome.getText();
        int tdiaNasc = Integer.parseInt(diaNasc.getText());
        int tdmesNasc = Integer.parseInt(mesNasc.getText());
        int tanoNasc = Integer.parseInt(anoNasc.getText());
        int tdiaAd = Integer.parseInt(diaAd.getText());
        int tdmesAd = Integer.parseInt(mesAd.getText());
        int tdanoAd = Integer.parseInt(anoAd.getText());
        double tsalario = Double.parseDouble(salario.getText());
        double ttrestante = Double.parseDouble(trestante.getText());
        String tsenha = senha.getText();
        //Gerente gerente = gerente.get

        //o gernte é temporario pq ainda não foi criado area de adicionar gerente, uma vez que tenha sido adicionado ao adicionar deve-se ser possivel escolher ele aqui
        Gerente gerenteTemp = new Gerente("4325432-x","anderson",1,1,1,2,2,2,1000,0,"senhaTemp");
        Vendedor novoVendedor = new Vendedor(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,ttrestante,gerenteTemp,tsenha);



        try {
            //BufferedWriter saida = new BufferedWriter(new FileWriter("clientes.txt"));

            File arq = new File("vendedores.txt");
            FileWriter saida = new FileWriter(arq, true);


            String textoSaida = trg + "~"+ tnome+ "~" +tdiaNasc+ "~"+tdmesNasc + "~"+tanoNasc + "~"+tdiaAd+ "~" + tdmesAd+ "~" + tdanoAd + "~"+tsalario + "~"+ttrestante  + "~"+gerenteTemp.getNome()+ "~"+ tsenha+"\n";

            saida.write(textoSaida);


            saida.close();
        } catch (IOException e) {
            System.out.println("erro: " + e);
        }

        MenuGerente menuGerente = new MenuGerente();
        close();



    }
    private void close(){
        setVisible(false);
        dispose();
    }

}
