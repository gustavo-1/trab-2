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
    private JButton removerFuncionarioButton;
    private JList listfuncionario;
    private JButton close;
    static List <Vendedor> listaVendedores = new ArrayList<Vendedor>();
    public ExcluirVendedor(){
        listaVendedores.clear();
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelApagarVendedor);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        DefaultListModel modeloVendedor = criaModeloVendedor();
        listfuncionario.setModel(modeloVendedor);


        removerFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicou();
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
    public ExcluirVendedor(int retornar, Vendedor v){
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelApagarVendedor);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        DefaultListModel modeloVendedor = criaModeloVendedor();
        listfuncionario.setModel(modeloVendedor);

        removerFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicou();

                MenuVendedor mv = new MenuVendedor(v);

                close();
            }
        });
    }

    public static void main(String[] args) {
        ExcluirVendedor ex = new ExcluirVendedor();
    }

    public void clicou(){
        int resposta1 = listfuncionario.getSelectedIndex();

        //agora deve se remover a linha selecionada
        try {
            File inputFile = new File("vendedores.txt");
            File tempFile = new File("vendedores2.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            for(int i=0;i< listaVendedores.size();i++){
                currentLine = reader.readLine();

                if(i != this.listfuncionario.getSelectedIndex()){
                    writer.write(currentLine);
                }
            }
            writer.close();
            reader.close();

            //le clientes2 de novo e salva tudo na string
            File vendedores2 = new File("vendedores2.txt");
            Scanner myReader2 = new Scanner(vendedores2);

            String textoCompleto="";
            while (myReader2.hasNextLine())
            {
                textoCompleto += myReader2.nextLine()+"\n";
            }
            myReader2.close();

            //apagar cliente

            inputFile.delete();

            // recria clientes.txt
            File novoVendedor = new File("vendedores.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter( novoVendedor));
            System.out.println("++++++++\n\n"+textoCompleto+"++++++++\n\n");
            escritor.write(textoCompleto);

            escritor.close();

            //apaga cliente2.txt
            vendedores2.delete();

        }
        catch (IOException e){
            System.out.println("Erro: " + e);
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
                double ttrestante =  Double.parseDouble(atributos[9]);
                //Gerente gerente = atributos[10]
                String tsenha  = atributos[11];

                //depois arrumar uma forma de passar o gerente correto, talvez buscar ele por rg
                Gerente gerenteGenerico= new Gerente("4325432-x","anderson",1,1,1,2,2,2,1000,0,"senhaGenerica");
                tempVendedor = new Vendedor(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,ttrestante,gerenteGenerico,tsenha);
                listaVendedores.add(tempVendedor);
            }
            myReader.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }
    }

    public DefaultListModel criaModeloVendedor(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Vendedor c: listaVendedores){
            temp = "Nome: " + c.getNome() + " CPF: " + c.getRg();
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
