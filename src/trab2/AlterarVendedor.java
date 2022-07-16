package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterarVendedor extends JFrame{
    private JPanel PainelEdtVendedor;
    private JTextField rg;
    private JTextField nome;
    private JTextField anoNasc;
    private JTextField salario;
    private JTextField diaNasc;
    private JTextField mesNasc;
    private JTextField trestante;
    private JComboBox listGerente;
    private JButton button1;
    private JTextField mesAd;
    private JTextField diaAd;
    private JTextField anoAd;
    private JTextField senha;
    private List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
    private JButton close;
    private JList list1;
    private int escolha;
    static List<Gerente> listaGerentes = new ArrayList<Gerente>();
    private Vendedor vendedorEscolhido;


    public AlterarVendedor(){
        listaVendedores.clear();
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelEdtVendedor);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        DefaultListModel modeloCliente = criaModeloVendedor();
        list1.setModel(modeloCliente);


        String temp;
        for(Gerente c: listaGerentes){
            temp = "Nome: " + c.getNome()+" CPF: " + c.getRg();
            listGerente.addItem(temp);

        }

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                escolherVendedor();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 clicou();
            }
        });
    }

    public static void main(String[] args) {
        AlterarVendedor ed = new AlterarVendedor();
    }

    public void escolherVendedor(){
        int escolha = list1.getSelectedIndex();
        this.escolha = escolha;
        System.out.println("Escolheu: " + escolha);

        //////////////

        Vendedor vendedorEscolhido = listaVendedores.get(escolha);
        rg.setText(vendedorEscolhido.getRg());
        nome.setText(vendedorEscolhido.getNome());
        diaNasc.setText(String.valueOf(vendedorEscolhido.getDataNascimento().getDia()));
        mesNasc.setText(String.valueOf(vendedorEscolhido.getDataNascimento().getMes()));
        anoNasc.setText(String.valueOf(vendedorEscolhido.getDataNascimento().getAno()));
        diaAd.setText(String.valueOf(vendedorEscolhido.getDataAdmissao().getDia()));
        mesAd.setText(String.valueOf(vendedorEscolhido.getDataAdmissao().getMes()));
        anoAd.setText(String.valueOf(vendedorEscolhido.getDataAdmissao().getAno()));


        salario.setText(String.valueOf(vendedorEscolhido.getSalario()));
        trestante.setText(String.valueOf(vendedorEscolhido.getTempoRestante()));
        senha.setText(String.valueOf(vendedorEscolhido.getSenha()));

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

                int index3=0;
                for(String s: atributos){
                    System.out.println("Atributos[" + index3 + "]:\n" + s);
                    index3++;
                }

                //depois arrumar uma forma de passar o gerente correto, talvez buscar ele por rg
                // Gerente gerenteGenerico= new Gerente("4325432-x","anderson",1,1,1,2,2,2,1000,0,"senhaGenerica");
                Gerente gerenteGenerico = new Gerente(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,tanosExp,tsenha);
                listaGerentes.add(gerenteGenerico);
            }
            myReader2.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }

        try{

            File arq = new File("vendedores.txt");
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
                double ttrestante = Double.parseDouble(atributos[9]);
              //  int tanosExp =  Integer.parseInt(atributos[9]);
                String nomeGerente= atributos[10];
                String tsenha  = atributos[11];

                int index3=0;
                for(String s: atributos){
                    System.out.println("Atributos[" + index3+ "]:\n" + s);
                    index3++;
                }

                //depois arrumar uma forma de passar o gerente correto, talvez buscar ele por rg
                // Gerente gerenteGenerico= new Gerente("4325432-x","anderson",1,1,1,2,2,2,1000,0,"senhaGenerica");
                Gerente gerenteVazio = new Gerente("4325432-x","Anderson",1,1,1,2,2,2,1000,0,"senhaGenerica");
                Vendedor vendedortemp= new Vendedor(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,ttrestante,gerenteVazio,tsenha);
                listaVendedores.add(vendedortemp);

            }

            myReader2.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }
    }

    // public static void main(String[] args) {
    //  AdicionarVendedor a = new AdicionarVendedor();
    // }


    public void clicou()  {
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

        String textoSaida = trg + "~"+ tnome+ "~" +tdiaNasc+ "~"+tdmesNasc + "~"+tanoNasc + "~"+tdiaAd+ "~" + tdmesAd+ "~" + tdanoAd + "~"+tsalario + "~"+ttrestante  + "~"+listaGerentes.get(escolha).getNome()+ "~"+ tsenha+"\n";

        System.out.println(textoSaida);

        String textoCompleto="";

        //Reescreve clientes com a linha alterada no lugar da antiga
        try {
            File inputFile = new File("vendedores.txt");
            File tempFile = new File("vendedores2.txt");


            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));


            String currentLine;


            for(int i=0;i< listaVendedores.size();i++){
                currentLine = reader.readLine();


                if(i != this.escolha){

                    writer.write(currentLine+"\n");


                }
                else{
                    //writer.newLine();
                    writer.write(textoSaida);
                    //writer.newLine();

                }

            }


            reader.close();
            writer.close();


            //le clientes2 de novo e salva tudo na string
            File Vendedores2 = new File("vendedores2.txt");
            Scanner myReader2 = new Scanner(Vendedores2);



            while (myReader2.hasNextLine())
            {
                textoCompleto += myReader2.nextLine()+"\n";
            }
            myReader2.close();



            //apagar cliente

            inputFile.delete();

            // recria clientes.txt
            File novoCliente = new File("vendedores.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter( novoCliente));
            System.out.println("++++++++\n\n"+textoCompleto+"++++++++\n\n");
            escritor.write(textoCompleto);

            escritor.close();

            //apaga cliente2.txt
            Vendedores2.delete();


        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }

        ///////////////////

        //volta para menu gerente apenas por enquanto
        MenuGerente mg = new MenuGerente();
        close();

    }

    public DefaultListModel criaModeloVendedor(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Vendedor c: listaVendedores){
            temp = "Nome: " + c.getNome()+" RG: " + c.getRg();
            modelo.addElement(temp);

        }

        return modelo;
    }
    private void close(){
        setVisible(false);
        dispose();
    }
}
