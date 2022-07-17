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
    private JPanel PainelAddMoto;
    private JList list1;
    private JList list2;
    private JLabel JLabelNchassi;
    private JLabel JLabelStatus;
    private JLabel cinlindradasLabel;
    private JTextField cilindradasMoto;
    private JButton adicionarMotoButton;
    private JTextField NchassiMoto;
    private JTextField marcaMoto;
    private JTextField modeloMoto;
    private JTextField anoMoto;
    private JTextField quilometragemMoto;
    private JTextField tipoMoto;
    private JTextField pesoMoto;
    private JCheckBox vendidoMoto;
    private JTextField tipoMoto2;
    private JButton close;
    private JLabel erroEntrada;
    private List<Carro> listaCarros = new ArrayList<Carro>();
    private List<Motocicleta> listaMoto = new ArrayList<Motocicleta>();

    public AlterarVeiculo(){
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1800,2100);

        this.setContentPane(PainelEdtCarro);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);





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
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                escolheuCarro();
            }
        });
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                escolheuMoto();
            }
        });
        AddCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicouCarro();
                MenuGerente mg = new MenuGerente();
            }

        });


        adicionarMotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicouMoto();
                //MenuGerente mg = new MenuGerente();
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

    //veio do funcionario
    public AlterarVeiculo(int retorna, Vendedor v){
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelEdtCarro);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.setSize(600,600);



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
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                escolheuCarro();
            }
        });
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                escolheuMoto();
            }
        });
        AddCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicouCarro();
                MenuVendedor mv = new MenuVendedor(v);
            }

        });
        adicionarMotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicouMoto();
                //MenuVendedor mv = new MenuVendedor(v);
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
        AlterarVeiculo av = new AlterarVeiculo();
    }

    public void escolheuCarro(){

        Carro carroEscolhido = listaCarros.get(list1.getSelectedIndex());

        Nchassi.setText(String.valueOf(carroEscolhido.getNumeroDoChassi()));
        marca.setText(String.valueOf(carroEscolhido.getMarca()));
        modelo.setText(String.valueOf(carroEscolhido.getModelo()));
        ano.setText(String.valueOf(carroEscolhido.getAno()));
        quilometragem.setText(String.valueOf(carroEscolhido.getKm()));
        tipoCombustivel.setText(String.valueOf(carroEscolhido.getTipoCombustivel()));
        peso.setText(String.valueOf(carroEscolhido.getPeso()));
        vendidoCheckBox.setText(String.valueOf(carroEscolhido.getVendido()));

        potencia.setText(String.valueOf(carroEscolhido.getPotencia()));
        nCilindros.setText(String.valueOf(carroEscolhido.getnDeCilindros()));
        nOcupantes.setText(String.valueOf(carroEscolhido.getnDeOcupantes()));
        tipo.setText(String.valueOf(carroEscolhido.getTipo()));
        altura.setText(String.valueOf(carroEscolhido.getDimensoes().getAltura()));
        largura.setText(String.valueOf(carroEscolhido.getDimensoes().getLargura()));
        comprimento.setText(String.valueOf(carroEscolhido.getDimensoes().getComprimento()));


    }
    public void escolheuMoto(){
        Motocicleta motoEscolhido = listaMoto.get(list2.getSelectedIndex());

        NchassiMoto.setText(String.valueOf(motoEscolhido.getNumeroDoChassi()));
        marcaMoto.setText(String.valueOf(motoEscolhido.getMarca()));
        modeloMoto.setText(String.valueOf(motoEscolhido.getModelo()));
        anoMoto.setText(String.valueOf(motoEscolhido.getAno()));
        quilometragemMoto.setText(String.valueOf(motoEscolhido.getKm()));
        tipoMoto.setText(String.valueOf(motoEscolhido.getTipoCombustivel()));
        pesoMoto.setText(String.valueOf(motoEscolhido.getPeso()));
        vendidoMoto.setText(String.valueOf(motoEscolhido.getVendido()));


        cilindradasMoto.setText(String.valueOf(motoEscolhido.getCilindradas()));

        tipoMoto2.setText(String.valueOf(motoEscolhido.getTipo()));


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
                    System.out.println("Atributos:\n"+s);
                }


                tempCarro = new Carro(numeroDoChassi ,marca,modelo,ano,km,tipoCombustivel,peso,vendido,potencia,nDeCilindros,nDeOcupantes, tipo,alt,larg,compri);
                listaCarros.add(tempCarro);

            }

            myReader.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
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

                int nDeCilindros = Integer.parseInt(atributos[8]);
                String tipo  = atributos[9];




                for(String s: atributos){
                    System.out.println("Atributos: \n" + s);
                }

                tempMotos = new Motocicleta(numeroDoChassi ,marca,modelo,ano,km,tipoCombustivel,peso,vendido,nDeCilindros, tipo);
                listaMoto.add(tempMotos);
            }

            myReader.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }
    }

    public void clicouCarro(){
        try{

        int nchassi = Integer.parseInt(Nchassi.getText());
        String tmarca = marca.getText();
        String tmodelo = modelo.getText();
        int tano = Integer.parseInt(ano.getText());
        double tquilometragem = Double.parseDouble(quilometragem.getText());
        String tTipoDeCombustivel = tipoCombustivel.getText();
        double tPeso = Double.parseDouble(peso.getText());
        boolean tVendido = vendidoCheckBox.isSelected();

        int tpotencia = Integer.parseInt(potencia.getText());
        int tnDeCilindros = Integer.parseInt(nCilindros.getText());
        int tnDeOcupantes = Integer.parseInt(nOcupantes.getText());
        String ttipo  = tipo.getText();
        double talt= Double.parseDouble(altura.getText());
        double tlarg= Double.parseDouble(largura.getText());
        double tcompri= Double.parseDouble(comprimento.getText());

        String textoSaida =  nchassi + "~"+ tmarca+ "~" + tmodelo + "~"+ tano + "~"+ tquilometragem + "~"+tTipoDeCombustivel+ "~" + tPeso + "~"+ tVendido  +"~"+tpotencia +"~"+tnDeCilindros+ "~" +tnDeOcupantes +"~"+ ttipo  +"~"+talt +"~"+tlarg+ "~" + tcompri+"\n";

        Carro carroNovo = new Carro(nchassi,tmarca,tmodelo,tano,tquilometragem,tTipoDeCombustivel,tPeso,tVendido,tpotencia,tnDeCilindros,tnDeOcupantes,ttipo,talt,tlarg,tcompri);

        String textoCompleto="";

        //Reescreve clientes com a linha alterada no lugar da antiga
        try {
            File inputFile = new File("carros.txt");
            File tempFile = new File("carros2.txt");


            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));


            String currentLine;


            for(int i=0;i< listaCarros.size();i++){
                currentLine = reader.readLine();


                if(i != list1.getSelectedIndex()){

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

            //le carros2 de novo e salva tudo na string
            File Vendedores2 = new File("carros2.txt");
            Scanner myReader2 = new Scanner(Vendedores2);

            while (myReader2.hasNextLine())
            {
                textoCompleto += myReader2.nextLine()+"\n";
            }
            myReader2.close();

            //apagar carro

            inputFile.delete();

            // recria clientes.txt
            File novoCliente = new File("carros.txt");
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
        //MenuGerente mg = new MenuGerente();
        close();
        }catch (Exception e){
            erroEntrada.setVisible(true);
            System.out.println("--------------------------------erro-----------------------------"+e);
        }
    }

    public void clicouMoto(){
        try{

        int nchaci = Integer.parseInt(NchassiMoto.getText());
        String tmarca = marcaMoto.getText();
        String tmodelo = modeloMoto.getText();
        int tano= Integer.parseInt(anoMoto.getText());
        double tquilometragem = Double.parseDouble(quilometragemMoto.getText());
        String tTipoDeCombustivel = tipoMoto.getText();
        double tPeso = Double.parseDouble(pesoMoto.getText());
        boolean tVendido = vendidoMoto.isSelected();

        int tcilindradas = Integer.parseInt(cilindradasMoto.getText());
        String ttipo  = tipoMoto2.getText();

        //informações especificas sobre carro ou moto ainda não foram adicionadas pra eu poder comecar a testar
        Motocicleta motoNova = new Motocicleta(nchaci,tmarca,tmodelo,tano,tquilometragem,tTipoDeCombustivel,tPeso,tVendido, tcilindradas,ttipo);
        String textoCompleto="";
        String textoSaida =  nchaci + "~"+ tmarca+ "~" + tmodelo + "~"+ tano + "~"+ tquilometragem + "~"+tTipoDeCombustivel+ "~" + tPeso + "~"+ tVendido  +"~"+tcilindradas + "~"+ ttipo+"\n";

        //Reescreve clientes com a linha alterada no lugar da antiga
        try {
            File inputFile = new File("motos.txt");
            File tempFile = new File("motos2.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            for(int i=0;i< listaMoto.size();i++){
                currentLine = reader.readLine();

                if(i != list2.getSelectedIndex()){
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

            //le carros2 de novo e salva tudo na string
            File Vendedores2 = new File("motos2.txt");
            Scanner myReader2 = new Scanner(Vendedores2);

            while (myReader2.hasNextLine())
            {
                textoCompleto += myReader2.nextLine()+"\n";
            }
            myReader2.close();

            //apagar carro

            inputFile.delete();

            // recria clientes.txt
            File novoCliente = new File("motos.txt");
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
        }catch (Exception e){
            erroEntrada.setVisible(true);
            System.out.println("--------------------------------erro-----------------------------"+e);
        }
    }




    public DefaultListModel criaModeloCarro(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Carro c: listaCarros){
            temp = "Modelo: " + c.getModelo() + " Marca: " + c.getMarca() + " Número: " + Integer.toString(c.getNumeroDoChassi()) + " Status de venda: " + c.getVendido();
            modelo.addElement(temp);
        }

        return modelo;
    }
    public DefaultListModel criaModeloMotos(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Motocicleta c: listaMoto){
            temp = "Modelo: " + c.getModelo() + " Marca: " + c.getMarca() + " Número: " + Integer.toString(c.getNumeroDoChassi()) + " Status de venda: "+ c.getVendido();
            modelo.addElement(temp);

        }

        return modelo;
    }
    private void close(){
        setVisible(false);
        dispose();
    }

}
