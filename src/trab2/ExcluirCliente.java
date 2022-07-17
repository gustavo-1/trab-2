package trab2;

import javax.swing.*;
import java.awt.*;
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
    private JButton close;
    private JPanel painelrr;
    public static List<Cliente> listaCliente = new ArrayList<Cliente>();
    public ExcluirCliente(){

        listaCliente.clear();
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
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGerente mg = new MenuGerente();
                close();
            }
        });
    }

    //veio do vendedor
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

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuVendedor mv = new MenuVendedor(v);
                close();
            }
        });
    }

    public static void main(String[] args) {
        ExcluirCliente ex = new ExcluirCliente();
    }

    public void clicou(){

        //Reescreve clientes com a linha alterada no lugar da antiga
        try {
            File inputFile = new File("clientes.txt");
            File tempFile = new File("clientes2.txt");


            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            for(int i=0;i< listaCliente.size();i++){
                currentLine = reader.readLine();


                if(i != this.list1.getSelectedIndex()){
                    writer.write(currentLine+"\n");
                }
            }
            reader.close();
            writer.close();

            //le clientes2 de novo e salva tudo na string
            File clientes2 = new File("clientes2.txt");
            Scanner myReader2 = new Scanner(clientes2);

            String textoCompleto="";
            while (myReader2.hasNextLine())
            {
                textoCompleto += myReader2.nextLine()+"\n";
            }
            myReader2.close();

            //apagar cliente

            inputFile.delete();

            // recria clientes.txt
            File novoCliente = new File("clientes.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter( novoCliente));
            System.out.println("++++++++\n\n"+textoCompleto+"++++++++\n\n");
            escritor.write(textoCompleto);

            escritor.close();

            //apaga cliente2.txt
            clientes2.delete();


        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }
    }

    public void ler(){

        //ler cliente
        try{

            File arq2= new File("clientes.txt");
            Scanner myReader2 = new Scanner(arq2);

            while(myReader2.hasNextLine()){

                String leitura = myReader2.nextLine();
                System.out.println("Leitura: \n" + leitura);

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

                Double renda =  Double.parseDouble(atributos2[9]) ;
                int dependentes =  Integer.parseInt(atributos2[10]) ;

                for(String s: atributos2){
                    System.out.println("Atributos: \n" + s);
                }

                Cliente clienteNovo = new Cliente(cpf, nome, dia, mes, ano, rua, nrua, bairro, cidade, renda, dependentes);

                listaCliente.add(clienteNovo);
            }
            myReader2.close();
        }
        catch (IOException e) {
            System.out.println("Erro: " + e);
        }
    }

    public DefaultListModel criaModeloCliente(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Cliente c: listaCliente){
            temp = "Nome: " + c.getNome() + " CPF: " + c.getCpf();
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
