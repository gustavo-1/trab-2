package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RemoverCarro extends JFrame {
    public static List<Carro> listaCarros = new ArrayList<Carro>();
    private JList list1;
    private JPanel PainelApagarCarro;
    private JButton removerButton;

    public RemoverCarro(){
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelApagarCarro);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        DefaultListModel modeloCarros = criaModeloCarro();
        list1.setModel(modeloCarros);


        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicou();
            }
        });
    }

    public static void main(String[] args) {
        RemoverCarro rc = new RemoverCarro();
    }


    public void clicou(){
        System.out.println("escolido: "+list1.getSelectedIndex());
        int resposta1 = list1.getSelectedIndex();

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

        ///////////////////



    }




    public void ler(){

        //ler carros
        try{
            //BufferedWriter saida = new BufferedWriter(new FileWriter("carros.txt"));

            File arq = new File("carros.txt");
            Scanner myReader = new Scanner(arq);
            //BufferedReader leitor = new BufferedReader(arq);


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



                for(String s: atributos){
                    System.out.println("atrubutos:\n"+s);
                }


                tempCarro = new Carro(numeroDoChassi ,marca,modelo,ano,km,tipoCombustivel,peso,vendido,potencia,nDeCilindros,nDeOcupantes, tipo,alt,larg,compri);
                listaCarros.add(tempCarro);



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
}
