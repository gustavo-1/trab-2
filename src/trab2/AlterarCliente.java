package trab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterarCliente extends JFrame {
    private JPanel PainelAlterar;
    private JPanel PainelAlterarCliente;
    private JButton close;
    private JLabel CPFLabel;
    private JLabel adicionarClienteLabel;
    private JLabel nomeLabel;
    private JLabel dataDeNascimentoLabel;
    private JLabel endereçoLabel;
    private JLabel ruaLabel;
    private JLabel númeroLabel;
    private JLabel bairroLabel;
    private JLabel cidadeLabel;
    private JTextField cidadetextfield;
    private JTextField bairrotextfield;
    private JTextField nruatextfield;
    private JTextField ruatextfield;
    private JLabel rendaLabel;
    private JLabel dependentesLabel;
    private JTextField dependentestextfield;
    private JTextField rendatextfield;
    private JTextField CPFtextfield;
    private JTextField nometextfield;
    private JTextField diatextfield;
    private JTextField mestextfield;
    private JTextField anotextfield;
    private JButton alterarClienteButton;
    private JList jlistaCliente;
    private int retornar;
    private int escolha;
    private Vendedor vendedor;
    static List<Cliente> listaCliente= new ArrayList<Cliente>();

    public AlterarCliente(){
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelAlterarCliente);
        //this.setLocationRelativeTo(null);
        //this.setSize(111,111);
        this.pack();
        this.setVisible(true);

        DefaultListModel modeloCliente = criaModeloCliente();
        jlistaCliente.setModel(modeloCliente);

        jlistaCliente.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                escolherCliente();
            }
        });
        jlistaCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                escolherCliente();
            }
        });
        alterarClienteButton.addActionListener(new ActionListener() {
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

    public static void main(String[] args) {
        AlterarCliente at = new AlterarCliente();
    }

    public void escolherCliente(){
        int escolha = jlistaCliente.getSelectedIndex();
        this.escolha = escolha;
        System.out.println("Escolheu: " + escolha);

        Cliente clienteEscolhido = listaCliente.get(escolha);

        CPFtextfield.setText(String.valueOf(clienteEscolhido.getCpf()));

        nometextfield.setText(String.valueOf(clienteEscolhido.getNome()));
        diatextfield.setText(String.valueOf(clienteEscolhido.getNascimento().getDia()));
        mestextfield.setText(String.valueOf(clienteEscolhido.getNascimento().getMes()));
        anotextfield.setText(String.valueOf(clienteEscolhido.getNascimento().getAno()));

        // endereço

        ruatextfield.setText(String.valueOf(clienteEscolhido.getRua()));
        nruatextfield.setText(String.valueOf(clienteEscolhido.getNrua()));
        bairrotextfield.setText(String.valueOf(clienteEscolhido.getBairro()));
       cidadetextfield.setText(String.valueOf(clienteEscolhido.getCidade()));


        rendatextfield.setText(String.valueOf(clienteEscolhido.getRenda()));
        dependentestextfield.setText(String.valueOf(clienteEscolhido.getDependentes()));


    }

    public void ler(){


        //ler clientes
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

                double renda =  Double.parseDouble(atributos2[9]) ;
                int dependentes =  Integer.parseInt(atributos2[10]) ;






                for(String s: atributos2){
                    System.out.println("Atributos: \n" + s);
                }

                Cliente clienteNovo = new Cliente(cpf, nome, dia, mes, ano, rua, nrua, bairro, cidade, renda, dependentes);

                listaCliente.add(clienteNovo);



            }


            myReader2.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }

        //System.out.println("dia1"+listaCliente.get(0).getNascimento().getDia());
        //System.out.println("dia2"+listaCliente.get(1).getNascimento().getDia());
    }

    public void clicou()  {
        int cpf = Integer.parseInt(CPFtextfield.getText());
        String nome = nometextfield.getText();
        int dia = Integer.parseInt(diatextfield.getText());
        int mes = Integer.parseInt(mestextfield.getText());
        int ano = Integer.parseInt(anotextfield.getText());

        // endereço
        String rua = ruatextfield.getText();
        int nrua = Integer.parseInt(nruatextfield.getText());
        String bairro = bairrotextfield.getText();
        String cidade = cidadetextfield.getText();
        // fim

        Double renda = Double.parseDouble(rendatextfield.getText());
        int dependentes = Integer.parseInt(dependentestextfield.getText());

        String textoSaida = cpf + "~" + nome + "~" + dia + "~" + mes + "~" + ano + "~" + rua + "~" + nrua + "~" + bairro + "~" + cidade + "~" + renda + "~" + dependentes;//+"\n";

        System.out.println(textoSaida);

        String textoCompleto="";

        //Reescreve clientes com a linha alterada no lugar da antiga
        try {
            File inputFile = new File("clientes.txt");
            File tempFile = new File("clientes2.txt");


            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            for(int i=0;i< listaCliente.size();i++){
                currentLine = reader.readLine();

                if(i != this.escolha){
                    writer.write(currentLine+"\n");
                }
                else{
                    //writer.newLine();
                    writer.write(textoSaida);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();

            //le clientes2 de novo e salva tudo na string
            File clientes2 = new File("clientes2.txt");
            Scanner myReader2 = new Scanner(clientes2);

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

        ///////////////////

        //volta para menu gerente apenas por enquanto
        //MenuGerente mg = new MenuGerente();
        close();

    }
    public DefaultListModel criaModeloCliente(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Cliente c: listaCliente){
            temp = "Nome: " + c.getNome() + " CPF:" + c.getCpf();
            modelo.addElement(temp);

        }

        return modelo;
    }
    private void close(){
        setVisible(false);
        dispose();
    }

}
