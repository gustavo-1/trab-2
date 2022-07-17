package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    static List<Gerente> listaGerentes = new ArrayList<Gerente>();

    private JButton close;
    private JComboBox listGerente;
    private JLabel erroEntrada;

    public AdicionarVendedor(){
        super("Adicionar Funcionário");
        listaGerentes.clear();
        ler();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelAddVendedor);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        String temp;
        for(Gerente c: listaGerentes){
            temp = "Nome: " + c.getNome() + " CPF: " + c.getRg();
            listGerente.addItem(temp);

        }

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

    //veio do vendedor
    public AdicionarVendedor(int retornar, Vendedor v){
        super("Adicionar Funcionário");
        ler();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelAddVendedor);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        String temp;
        for(Gerente c: listaGerentes){
            temp = "Nome: " + c.getNome() + " CPF: " + c.getRg();
            listGerente.addItem(temp);

        }

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVendedor();
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuVendedor mv = new MenuVendedor(v);
                close();
            }
        });
    }

    public static void main(String[] args) {
        AdicionarVendedor ad = new AdicionarVendedor();
    }

    private void ler() {
        try{

            File arq = new File("gerentes.txt");
            Scanner myReader2 = new Scanner(arq);

            Vendedor tempVendedor;

            while(myReader2.hasNextLine()){

                String leitura = myReader2.nextLine();
                System.out.println("Leitura: \n" + leitura);

                String[] atributos = leitura.split("~");

                String trg  = atributos[0];
                String tnome  = atributos[1];
                int tdiaNasc = Integer.parseInt(atributos[2]) ;
                int tdmesNasc = Integer.parseInt(atributos[3]) ;
                int tanoNasc = Integer.parseInt(atributos[4]) ;
                int tdiaAd= Integer.parseInt(atributos[5]) ;
                int tdmesAd = Integer.parseInt(atributos[6]) ;
                int tdanoAd = Integer.parseInt(atributos[7]) ;
                double tsalario = Double.parseDouble(atributos[8]);
                int tanosExp =  Integer.parseInt(atributos[9]);

                String tsenha  = atributos[10];

                Gerente gerenteGenerico = new Gerente(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,tanosExp,tsenha);
                listaGerentes.add(gerenteGenerico);
            }
            myReader2.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }
    }

    public void adicionarVendedor(){
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
        double ttrestante = Double.parseDouble(trestante.getText());
        String tsenha = senha.getText();

        Gerente gerenteTemp = listaGerentes.get(listGerente.getSelectedIndex());
        Vendedor novoVendedor = new Vendedor(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,ttrestante,gerenteTemp,tsenha);

        try {
            File arq = new File("vendedores.txt");
            FileWriter saida = new FileWriter(arq, true);

            String textoSaida = trg + "~"+ tnome+ "~" +tdiaNasc+ "~"+tdmesNasc + "~"+tanoNasc + "~"+tdiaAd+ "~" + tdmesAd+ "~" + tdanoAd + "~"+tsalario + "~"+ttrestante  + "~"+gerenteTemp.getNome()+ "~"+ tsenha+"\n";

            saida.write(textoSaida);

            saida.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }

        MenuGerente menuGerente = new MenuGerente();
        close();

        }catch (Exception e){
            erroEntrada.setVisible(true);
            System.out.println("--------------------------------erro-----------------------------"+e);
        }
    }

    public DefaultListModel criaModeloGerente(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Gerente c: listaGerentes){
            temp = "Nome: " + c.getNome() + " CPF:" + c.getRg();
            modelo.addElement(temp);
        }

        return modelo;
    }
    private void close(){
        setVisible(false);
        dispose();
    }

}
