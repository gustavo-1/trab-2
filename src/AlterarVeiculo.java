import trab2.Carro;
import trab2.Cliente;
import trab2.Motocicleta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterarVeiculo extends JFrame {
    private JButton carroButton;
    private JButton motoButton;
    private JPanel PainelEdtCarro;
    private JPanel PainelAddCarro;
    private JLabel númeroDoChassiLabel;
    private JLabel JLabelPeso;
    private JLabel JLabelKM;
    private JLabel JLabelAno;
    private JLabel JLabelModelo;
    private JLabel JLabelMarca;
    private JTextField Nchassi;
    private JTextField marca;
    private JTextField modelo;
    private JTextField ano;
    private JTextField quilometragem;
    private JTextField peso;
    private JTextField potencia;
    private JTextField nCilindros;
    private JTextField nOcupantes;
    private JTextField tipo;
    private JTextField altura;
    private JTextField largura;
    private JTextField comprimento;
    private JLabel statusLabel;
    private JLabel potenciaLabel;
    private JLabel númeroDeCilindrosLabel;
    private JLabel númeroDeOcupantesLabel;
    private JLabel tipoLabel;
    private JLabel alturaLabel;
    private JLabel larguraLabel;
    private JLabel comprimentoLabel;
    private JCheckBox vendidoCheckBox;
    private JButton AddCarro;
    private JLabel tipoDeCombustívelLabel;
    private JTextField tipoCombustivel;
    private JButton close;
    private JPanel PainelAddMoto;
    private JLabel JLabelNchassi;
    private JLabel JLabelStatus;
    private JLabel cinlindradasLabel;
    private JTextField cilindradas;
    private JButton adicionarMotoButton;
    private JList list1;
    private JList list2;
    private List<Carro> listaCarros = new ArrayList<Carro>();
    private List<Motocicleta> listaMoto = new ArrayList<Motocicleta>();

    public AlterarVeiculo(){
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelEdtCarro);
        this.pack();
        //this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(500,600);


        DefaultListModel modeloCarros = criaModeloCarro();
        list1.setModel(modeloCarros);

        DefaultListModel modeloMotos = criaModeloMotos();
        list2.setModel(modeloMotos);




        carroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PainelAddCarro.setVisible(true);
                PainelAddMoto.setVisible(false);

            }
        });
        motoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                PainelAddCarro.setVisible(false);
                PainelAddMoto.setVisible(true);

            }
        });
    }


    public static void main(String[] args) {
        AlterarVeiculo av = new AlterarVeiculo();
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
                    System.out.println("Atributos:\n"+s);
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


            Motocicleta tempMotos;

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
                    System.out.println("atrubutos:\n"+s);
                }


                tempMotos = new Motocicleta(numeroDoChassi ,marca,modelo,ano,km,tipoCombustivel,peso,vendido,nDeCilindros, tipo);
                listaMoto.add(tempMotos);



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
            temp = "modelo:"+c.getModelo()+" marca:" + c.getMarca() +" numero:"+ Integer.toString(c.getNumeroDoChassi()) + "vendido"+ c.getVendido();
            modelo.addElement(temp);

        }

        return modelo;
    }
    public DefaultListModel criaModeloMotos(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Motocicleta c: listaMoto){
            temp = "modelo:"+c.getModelo()+" marca:" + c.getMarca() +" numero:"+ Integer.toString(c.getNumeroDoChassi()) + " Vendido: "+ c.getVendido();
            modelo.addElement(temp);

        }

        return modelo;
    }
    private void close(){
        setVisible(false);
        dispose();
    }

}
