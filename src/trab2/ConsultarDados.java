package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarDados extends JFrame{
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JPanel painelConsultar;
    private JButton close;
    static List<Carro> listaCarros= new ArrayList<Carro>();
    static List<Cliente>  listaCliente= new ArrayList<Cliente>();
    static List <Motocicleta> listaMotos= new ArrayList<Motocicleta>();
    static List <Venda> listaVendas= new ArrayList<Venda>();

    public ConsultarDados(){
        listaCliente.clear();
        listaCarros.clear();
        listaCarros.clear();

        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelConsultar);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(900,500);


        DefaultListModel modeloCarros = criaModeloCarro();
        list1.setModel(modeloCarros);

        DefaultListModel modeloMotos = criaModeloMotos();
        list2.setModel(modeloMotos);

        DefaultListModel modeloCliente = criaModeloCliente();
        list3.setModel(modeloCliente);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGerente mg = new MenuGerente();
                close();

            }
        });
    }

    public ConsultarDados(Vendedor v){
        listaCliente.clear();
        listaCarros.clear();
        listaCarros.clear();

        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelConsultar);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(900,500);


        DefaultListModel modeloCarros = criaModeloCarro();
        list1.setModel(modeloCarros);

        DefaultListModel modeloMotos = criaModeloMotos();
        list2.setModel(modeloMotos);

        DefaultListModel modeloCliente = criaModeloCliente();
        list3.setModel(modeloCliente);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuVendedor mv = new MenuVendedor(v);
                close();

            }
        });
    }

    public static void main(String[] args) {
        ConsultarDados cs = new ConsultarDados();
    }

    public void ler(){
        //ler carros
        try{
            File arq = new File("carros.txt");
            Scanner myReader = new Scanner(arq);

            Carro tempCarro;

            while(myReader.hasNextLine()){

                String leitura = myReader.nextLine();
                System.out.println("Leitura: \n" + leitura);

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
            System.out.println("Erro: " + e);
        }

        //ler clientes
        try{
            File arq2= new File("clientes.txt");
            Scanner myReader2 = new Scanner(arq2);

            while(myReader2.hasNextLine()){
                String leitura = myReader2.nextLine();

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

                Cliente clienteNovo = new Cliente(cpf, nome, dia, mes, ano, rua, nrua, bairro, cidade, renda, dependentes);

                listaCliente.add(clienteNovo);
            }
            myReader2.close();
        }
        catch (IOException e){
            System.out.println("Erro: "+e);
        }

        //ler motos
        try{
            File arq = new File("motos.txt");
            Scanner myReader = new Scanner(arq);

            Motocicleta tempMotos;

            while(myReader.hasNextLine()){
                String leitura = myReader.nextLine();
                System.out.println("Leitura: \n"+leitura);

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

                tempMotos = new Motocicleta(numeroDoChassi ,marca,modelo,ano,km,tipoCombustivel,peso,vendido,nDeCilindros, tipo);
                listaMotos.add(tempMotos);
            }
            myReader.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }

        //ler vendas


    }






    public DefaultListModel criaModeloCarro(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Carro c: listaCarros){
            temp = "Modelo: " + c.getModelo() + " Marca: " + c.getMarca() +" Número: "+ Integer.toString(c.getNumeroDoChassi()) + " Status de venda: " + c.getVendido();
            modelo.addElement(temp);

        }
        return modelo;
    }
    public DefaultListModel criaModeloMotos(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Motocicleta c: listaMotos){
            temp = "Modelo: " + c.getModelo()+" Marca: " + c.getMarca() +" Número: " + Integer.toString(c.getNumeroDoChassi()) + " Vendido: "+ c.getVendido();
            modelo.addElement(temp);

        }

        return modelo;
    }
    public DefaultListModel criaModeloCliente(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Cliente c: listaCliente){
            temp = "Nome: " + c.getNome()+" CPF: " + c.getCpf();
            modelo.addElement(temp);

        }
        return modelo;
    }

    public DefaultListModel criaModeloVenda(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        try{
            File arq = new File("vendas.txt");
            Scanner myReader = new Scanner(arq);
            //BufferedReader leitor = new BufferedReader(arq);

            Vendedor tempVendedor;

            while(myReader.hasNextLine()){

                String leitura = myReader.nextLine();
                System.out.println("Leitura: \n" + leitura);

                String[] atributos = leitura.split("~");


                int tid = Integer.parseInt(atributos[0]);//id venda

                String nomeVendedor = atributos[1];//nome vendedor
                int cpfCliente =Integer.parseInt( atributos[2]);//cpf cliente
                String tipoVeiculo = atributos[3];//tipo Veiculo
                String tipoPagamento = atributos[10];

                temp = "carro: " + tipoVeiculo+" vendedor: " + nomeVendedor +"cliente(cpf): " +cpfCliente;
                modelo.addElement(temp);
            }
            myReader.close();
        }
        catch (IOException e){
            System.out.println("Erro: "+e);
        }




        return modelo;
    }

    private void close(){
        setVisible(false);
        dispose();
    }
}
