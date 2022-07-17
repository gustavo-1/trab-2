package trab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuVender extends JFrame{
    private JPanel painelvender;
    private JList listCarros;
    private JButton venderCarroButton;
    private JList jlistaCliente;
    private JTextField valor;
    private JTextField hora;
    private JTextField minutos;
    private JTextField segundos;
    private JTextField dia;
    private JTextField mes;
    private JTextField ano;
    private JTextField id;
    private JButton close;
    private JList listMotos;
    private JButton venderMotoButton;
    private JLabel NomeVendedor;
    private JComboBox tipopagamento;
    private JLabel tipo;
    static List<Carro>  listaCarros= new ArrayList<Carro>();
    static List<Cliente>  listaCliente= new ArrayList<Cliente>();
    static List <Motocicleta> listaMotos= new ArrayList<Motocicleta>();
    private Vendedor vendedor;



    public MenuVender(Vendedor v){
        listaCliente.clear();
        listaCarros.clear();
        listaCarros.clear();

        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelvender);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.setSize(111,111);
        this.vendedor = v;
        NomeVendedor.setText(v.getNome());

        DefaultListModel modeloCarros = criaModeloCarro();
        listCarros.setModel(modeloCarros);

        DefaultListModel modeloMotos = criaModeloMotos();
        listMotos.setModel(modeloMotos);

        DefaultListModel modeloCliente = criaModeloCliente();
        jlistaCliente.setModel(modeloCliente);

        venderCarroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venderCarro();
            }
        });


        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuVendedor mv = new MenuVendedor(v);
                close();
            }
        });
        venderMotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venderMoto();
            }
        });
    }

    public static void main(String[] args) {

       // MenuVender m = new MenuVender();

    }
    public void venderCarro(){

        System.out.println("Escolhido: "+ listCarros.getSelectedIndex());
        int resposta1 = listCarros.getSelectedIndex();
        int resposta2 = jlistaCliente.getSelectedIndex();
        //if(resposta1 >= 0 && 1 < listaCarros.size() && resposta2 >= 0 && 1 < listaCliente.size() ){
        if(resposta1 >= 0 && 0< listaCarros.size() && resposta2 >= 0 && 0 < listaCliente.size() ){
            //entrada valida
            System.out.println("Entrada válida");

            //criar objeto venda inserir cliente e carro nele e salvar
            int tid = Integer.parseInt(id.getText());
            int tdia = Integer.parseInt(dia.getText());
            int tmes = Integer.parseInt(mes.getText());
            int tano = Integer.parseInt(ano.getText());
            int thora = Integer.parseInt(hora.getText());
            int tminutos = Integer.parseInt(minutos.getText());
           // int tsegundos = Integer.parseInt(segundos.getText());
            double tvalor = Double.parseDouble(valor.getText());
            String tipoPagamento = Objects.toString(tipopagamento.getSelectedItem());

            Vendedor vendedor = this.vendedor;
            Cliente cliente = listaCliente.get(resposta2);
            Carro veiculo = listaCarros.get(resposta1);

            if(veiculo.getVendido()){
                System.out.println("Já está vendido!");
                ////colocar na tela
                return;
            }

            Venda venda = new Venda(tid,vendedor,cliente,veiculo,tvalor,tdia,tmes,tano,thora,tminutos);
            /////escrever venda e desempenho do vendedor

            try {
                //BufferedWriter saida = new BufferedWriter(new FileWriter("clientes.txt"));
                File arq = new File("vendas.txt");
                FileWriter saida = new FileWriter(arq, true);

                String textoSaida = tid + "~"+ vendedor.getNome() + "~" + cliente.getCpf() + "~" + veiculo.getTipo() + "~"+tvalor + "~" + tdia + "~" +tmes+ "~"+tano + "~"+thora + "~"+tminutos + "~" + tipoPagamento + "\n" ;

                saida.write(textoSaida);

                saida.close();

            } catch (IOException e) {
                System.out.println("Erro: " + e);
            }
            MenuVendedor m = new MenuVendedor(this.vendedor);

            close();

        }
        else{
            //talvez colocar um aviso na tela depois
            System.out.println("Entrada inválida!");
        }

    }
    public void venderMoto(){

        System.out.println("Escolhido: " + listCarros.getSelectedIndex());
        int resposta1 = listMotos.getSelectedIndex();
        int resposta2 = jlistaCliente.getSelectedIndex();
        //if(resposta1 >= 0 && 1 < listaCarros.size() && resposta2 >= 0 && 1 < listaCliente.size() ){
        if(resposta1 >= 0 && 0< listaCarros.size() && resposta2 >= 0 && 0 < listaCliente.size() ){
            //entrada valida
            System.out.println("Entrada válida");

            //criar objeto venda inserir cliente e carro nele e salvar
            int tid = Integer.parseInt(id.getText());
            int tdia = Integer.parseInt(dia.getText());
            int tmes = Integer.parseInt(mes.getText());
            int tano = Integer.parseInt(ano.getText());
            int thora = Integer.parseInt(hora.getText());
            int tminutos = Integer.parseInt(minutos.getText());
            // int tsegundos = Integer.parseInt(segundos.getText());
            double tvalor = Double.parseDouble(valor.getText());
            String tipoPagamento = Objects.toString(tipopagamento.getSelectedItem());

            Vendedor vendedor = this.vendedor;
            Cliente cliente = listaCliente.get(resposta2);
            Motocicleta veiculo = listaMotos.get(resposta1);

            if(!veiculo.getVendido()){
                System.out.println("Já está vendido!");
                ////colocar na tela
                return;
            }

            Venda venda = new Venda(tid,vendedor,cliente,veiculo,tvalor,tdia,tmes,tano,thora,tminutos);
            /////escrever venda;

            try {
                //BufferedWriter saida = new BufferedWriter(new FileWriter("clientes.txt"));

                File arq = new File("vendas.txt");
                FileWriter saida = new FileWriter(arq, true);


                String textoSaida = tid + "~" + vendedor.getNome()+ "~" + cliente.getCpf() + "~" + veiculo.getTipo() + "~" + tvalor  + " ~ " + tdia+ "~" +tmes+ "~"+tano + "~" + thora + "~" + tminutos + "~" + tipoPagamento + "\n" ;

                saida.write(textoSaida);

                saida.close();


            } catch (IOException e) {
                System.out.println("Erro: " + e);
            }
            MenuVendedor m = new MenuVendedor(this.vendedor);

            close();

        }
        else{
            //talvez colocar um aviso na tela depois
            System.out.println("Entrada inválida!");
        }
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

                for(String s: atributos){
                    System.out.println("Atributos: \n" + s);
                }

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
                System.out.println("Leitura: \n"+leitura);

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
                    System.out.println("Atributos:\n"+s);
                }

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
            //BufferedWriter saida = new BufferedWriter(new FileWriter("carros.txt"));

            File arq = new File("motos.txt");
            Scanner myReader = new Scanner(arq);
            //BufferedReader leitor = new BufferedReader(arq);

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

                for(String s: atributos){
                    System.out.println("Atributos: \n" + s);
                }

                tempMotos = new Motocicleta(numeroDoChassi ,marca,modelo,ano,km,tipoCombustivel,peso,vendido,nDeCilindros, tipo);
                listaMotos.add(tempMotos);
            }
            myReader.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }
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

    private void close(){
        setVisible(false);
        dispose();
    }
}
