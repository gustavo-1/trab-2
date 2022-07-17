package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Desempenho extends JFrame{
    private JPanel paineldesempenho;
    private JButton close;
    private JTextArea textvendedor;
    private JTextArea texteqtdvendas;
    private JTextArea textpayment;
    private JTextArea textmostpopularcar;
    private JLabel fieldVendedor;
    private JLabel fieldQtdvendedor;
    private JLabel fieldTipopagamento;
    private JLabel fieldMostpopularcar;

    /* public Desempenho(){
        ler();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(paineldesempenho);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        DefaultListModel modeloCarros = criaModeloCarro();
        listCarros.setModel(modeloCarros);
        DefaultListModel modeloMotos = criaModeloMoto();
        listMotos.setModel(modeloMotos);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGerente mg = new MenuGerente();
                close();
            }
        });

    }
    public void close() {
        setVisible(false);
        dispose();
    }



    //////////////////////////////q






    public void ler(){

        //ler vendedor
        try{

            File arq = new File("vendas.txt");
            Scanner myReader = new Scanner(arq);
            //BufferedReader leitor = new BufferedReader(arq);

            Vendedor tempVendedor;

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



                for(String s: atributos){
                    System.out.println("atributos:\n"+s);
                }


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
            //BufferedWriter saida = new BufferedWriter(new FileWriter("carros.txt"));

            File arq = new File("motos.txt");
            Scanner myReader = new Scanner(arq);
            //BufferedReader leitor = new BufferedReader(arq);


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





                for(String s: atributos){
                    System.out.println("atributos:\n"+s);
                }


                tempMoto = new Motocicleta(numeroDoChassi ,marca,modelo,ano,km,tipoCombustivel,peso,vendido,nDeCilindros, tipo);
                listaMotos.add(tempMoto);

            }

            myReader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }

    } */
}

