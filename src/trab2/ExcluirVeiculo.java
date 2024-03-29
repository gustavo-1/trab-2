package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ExcluirVeiculo extends JFrame {
    public static List<Carro> listaCarros = new ArrayList<Carro>();
    public static List<Motocicleta> listaMotos = new ArrayList<Motocicleta>();
    private JList listCarros;
    private JPanel PainelApagarCarro;
    private JButton removerButton;
    private JLabel labelMoti;
    private JList listMotos;
    private JButton removerButton1;
    private JButton close;
    private int retornar;
    private Vendedor vendedor;

    public ExcluirVeiculo(int retornar, Vendedor v){
        listaMotos.clear();
        listaMotos.clear();
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelApagarCarro);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.retornar = retornar;
        this.vendedor=v;

        DefaultListModel modeloCarros = criaModeloCarro();
        listCarros.setModel(modeloCarros);
        DefaultListModel modeloMotos = criaModeloMoto();
        listMotos.setModel(modeloMotos);

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicouCarro();
                MenuVendedor mv = new MenuVendedor(v);
                close();
            }
        });
        removerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicouMoto();
                MenuGerente mg = new MenuGerente();
                close();
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

    public ExcluirVeiculo(){
        listaMotos.clear();
        listaMotos.clear();

        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelApagarCarro);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        DefaultListModel modeloCarros = criaModeloCarro();
        listCarros.setModel(modeloCarros);
        DefaultListModel modeloMotos = criaModeloMoto();
        listMotos.setModel(modeloMotos);

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicouCarro();
                MenuGerente mg = new MenuGerente();
                close();
            }
        });
        removerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicouMoto();
                MenuGerente mg = new MenuGerente();
                close();
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGerente mg = new MenuGerente();
                close();
            }
        });
    }

    public void clicouCarro(){
        int resposta1 = listCarros.getSelectedIndex();

        //agora deve se remover a linha selecionada
        try {
            File inputFile = new File("carros.txt");
            File tempFile = new File("carros.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            for(int i=0;i< listaCarros.size();i++){
                currentLine = reader.readLine();
                if(i != resposta1){
                    writer.write(currentLine);
                }

            }

            writer.close();
            reader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }
    }
    public void clicouMoto(){
        int resposta1 = listMotos.getSelectedIndex();

        //agora deve se remover a linha selecionada
        try {
            File inputFile = new File("motos.txt");
            File tempFile = new File("motos.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            for(int i=0;i< listaMotos.size();i++){
                currentLine = reader.readLine();
                if(i != resposta1){
                    writer.write(currentLine);
                }
            }

            writer.close();
            reader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }
    }

    public void ler(){

        //ler carros
        try{
            File arq = new File("carros.txt");
            Scanner myReader = new Scanner(arq);

            Carro tempCarro;

            while(myReader.hasNextLine()){
                String leitura = myReader.nextLine();
                System.out.println("leitura:\n"+leitura);

                String[] atributos = leitura.split("~");

                int numeroDoChassi = Integer.parseInt(atributos[0]) ;
                String marca = atributos[1];
                String modelo  = atributos[2];
                int ano = Integer.parseInt(atributos[3]);
                double km = Double.parseDouble(atributos[4]);
                String tipoCombustivel = atributos[5];
                double peso = Double.parseDouble(atributos[6]);
                boolean vendido= Boolean.parseBoolean(atributos[7]);
                int potencia = Integer.parseInt(atributos[8]);
                int nDeCilindros = Integer.parseInt(atributos[9]);
                int nDeOcupantes = Integer.parseInt(atributos[10]);
                String tipo  = atributos[11];
                double alt= Double.parseDouble(atributos[12]);
                double larg= Double.parseDouble(atributos[13]);
                double compri= Double.parseDouble(atributos[14]);

                tempCarro = new Carro(numeroDoChassi ,marca,modelo,ano,km,tipoCombustivel,peso,vendido,potencia,nDeCilindros,nDeOcupantes, tipo,alt,larg,compri);
                listaCarros.add(tempCarro);
            }
            myReader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }
        //ler motos

        try{
            File arq = new File("motos.txt");
            Scanner myReader = new Scanner(arq);

            Motocicleta tempMoto;

            while(myReader.hasNextLine()){
                String leitura = myReader.nextLine();
                System.out.println("leitura:\n"+leitura);

                String[] atributos = leitura.split("~");

                int numeroDoChassi = Integer.parseInt(atributos[0]) ;
                String marca = atributos[1];
                String modelo  = atributos[2];
                int ano = Integer.parseInt(atributos[3]);
                double km = Double.parseDouble(atributos[4]);
                String tipoCombustivel = atributos[5];
                double peso = Double.parseDouble(atributos[6]);
                boolean vendido= Boolean.parseBoolean(atributos[7]);

                int nDeCilindros = Integer.parseInt(atributos[8]);
                String tipo  = atributos[9];

                tempMoto = new Motocicleta(numeroDoChassi ,marca,modelo,ano,km,tipoCombustivel,peso,vendido,nDeCilindros, tipo);
                listaMotos.add(tempMoto);
            }

            myReader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }
    }
    public DefaultListModel criaModeloCarro(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Carro c: listaCarros){
            temp = "modelo:"+c.getModelo()+" marca:" + c.getMarca() +" numero:"+ Integer.toString(c.getNumeroDoChassi());
            modelo.addElement(temp);
        }
        return modelo;
    }

    public DefaultListModel criaModeloMoto(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Motocicleta c: listaMotos){
            temp = "modelo:"+c.getModelo()+" marca:" + c.getMarca() +" numero:"+ Integer.toString(c.getNumeroDoChassi());
            modelo.addElement(temp);

        }

        return modelo;
    }
    public void close() {
        setVisible(false);
        dispose();
    }
}
