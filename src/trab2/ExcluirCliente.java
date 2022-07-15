package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcluirCliente extends JFrame {
    private JPanel pa;
    private JPanel PainelApagarCliente;
    private JButton removerClienteButton;
    private JList list1;
    private JPanel painelrr;
    public static List<Cliente> listaCliente = new ArrayList<Cliente>();
    public ExcluirCliente(){
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelApagarCliente);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        DefaultListModel modeloCliente = criaModeloCliente();
        list1.setModel(modeloCliente);


        removerClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicou();

                MenuGerente mg = new MenuGerente();

                close();
            }
        });
    }

    public ExcluirCliente(int retornar, Vendedor v){
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelApagarCliente);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        DefaultListModel modeloCliente = criaModeloCliente();
        list1.setModel(modeloCliente);


        removerClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicou();

                MenuVendedor mv = new MenuVendedor(v);

                close();
            }
        });
    }

    public static void main(String[] args) {
        ExcluirCliente ex = new ExcluirCliente();
    }

    public void clicou(){
        System.out.println("escolido: "+list1.getSelectedIndex());
        int resposta1 = list1.getSelectedIndex();

        //agora deve se remover a linha selecionada
        try {
            File inputFile = new File("clientes.txt");
            File tempFile = new File("clientes.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));


            String currentLine;


            for(int i=0;i< listaCliente.size();i++){
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

        //ler cliente
        try{


            File arq2= new File("clientes.txt");
            Scanner myReader2 = new Scanner(arq2);



            while(myReader2.hasNextLine()){



                String leitura = myReader2.nextLine();
                System.out.println("leitura:\n"+leitura);

                String[] atributos2 = leitura.split("~");

                int cpf = Integer.parseInt(atributos2[0]) ;
                String nome = atributos2[1];
                int dia =  Integer.parseInt(atributos2[2]) ;
                int mes =  Integer.parseInt(atributos2[3]) ;
                int ano =  Integer.parseInt(atributos2[4]) ;

                // endereço
                String rua = atributos2[5];
                int nrua =  Integer.parseInt(atributos2[6]) ;
                String bairro = atributos2[7];
                String cidade= atributos2[8];
                // fim

                int renda =  Integer.parseInt(atributos2[9]) ;
                int dependentes =  Integer.parseInt(atributos2[10]) ;






                for(String s: atributos2){
                    System.out.println("atrubutos:\n"+s);
                }

                Cliente clienteNovo = new Cliente(cpf, nome, dia, mes, ano, rua, nrua, bairro, cidade, renda, dependentes);

                listaCliente.add(clienteNovo);



            }


            myReader2.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }








    }


    public DefaultListModel criaModeloCliente(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Cliente c: listaCliente){
            temp = "nome:"+c.getNome()+" cpf:" + c.getCpf();
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
