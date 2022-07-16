package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcluirVendedor extends JFrame{
    private JPanel PainelApagarVendedor;
    private JButton removerClienteButton;
    private JList list1;
    private JButton close;
    static List <Vendedor> listaVendedores = new ArrayList<Vendedor>();

    public ExcluirVendedor(){
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelApagarVendedor);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        DefaultListModel modeloCliente = criaModeloVendedor();
        list1.setModel(modeloCliente);


        removerClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicou();
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

    public void clicou(){

        System.out.println("escolido: "+list1.getSelectedIndex());
        int resposta1 = list1.getSelectedIndex();

        //agora deve se remover a linha selecionada
        try {
            File inputFile = new File("vendedores.txt");
            File tempFile = new File("vendedores.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));


            String currentLine;


            for(int i=0;i< listaVendedores.size();i++){
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
        MenuGerente mg = new MenuGerente();
        close();


    }

    public void ler(){


        //ler vendedores
        try{


            File arq = new File("vendedores.txt");
            Scanner myReader = new Scanner(arq);



            Vendedor tempVendedor;

            while(myReader.hasNextLine()){



                String leitura = myReader.nextLine();
                System.out.println("leitura:\n"+leitura);

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
                double ttrestante =  Double.parseDouble(atributos[9]);
                //Gerente gerente = atributos[10]
                String tsenha  = atributos[11];




                for(String s: atributos){
                    System.out.println("atrubutos:\n"+s);
                }

                //depois arrumar uma forma de passar o gerente correto, talvez buscar ele por rg
                Gerente gerenteGenerico= new Gerente("4325432-x","anderson",1,1,1,2,2,2,1000,0,"senhaGenerica");
                tempVendedor = new Vendedor(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,ttrestante,gerenteGenerico,tsenha);
                listaVendedores.add(tempVendedor);



            }


            myReader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }








    }

    public DefaultListModel criaModeloVendedor(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Vendedor c: listaVendedores){
            temp = "nome:"+c.getNome()+" cpf:" + c.getRg();
            modelo.addElement(temp);

        }

        return modelo;
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    private void close(){
        setVisible(false);
        dispose();
    }

}
