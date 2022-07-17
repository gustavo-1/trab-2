package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Desempenho extends JFrame{
    private JPanel paineldesempenho;
    private JButton close;
    private JTextArea textvendedor;
    private JTextArea texteqtdvendas;
    private JTextArea textpayment;
    private JTextArea textmostpopularcar;
    private JLabel fieldVendedor;
    private JLabel fieldQtdvendedor;
    private JLabel fieldTipopagamento;
    private JLabel fieldMostpopularcar;
    private Vendedor vendedor;
    private String nomevendedor;
    static List <DesempenhoVendedor> listaDesempenho= new ArrayList<DesempenhoVendedor>();
    public int totalVendas;
    Map<String, Integer> stringsCount = new HashMap<>();
    public  String nomeVendedor;

    public int totPrazo;
    public int totVista;
    //carros
    public int utilitário;
    public int pickup;
    public int sedan;
    public int hatch;
    public int esportivo;
    //motos
    public int trail;
    public int street;
    public int esportiva;
    public int custom;


    public Desempenho(String nomevendedor){
        this.nomeVendedor=nomevendedor;
        System.out.println("========nomevendedor: "+this.nomeVendedor);
        this.totalVendas=0;
        this.totPrazo=0;
        totalVendas=0;

        ler();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(paineldesempenho);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);



        //textvendedor.setText(nomevendedor);
       // textmostpopularcar.setText(tipoMaisPopular().toString());
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGerente mg = new MenuGerente();
                close();
            }
        });




        //sobe informacoes para a tela
        textvendedor.setText(nomevendedor);
        texteqtdvendas.setText(String.valueOf(this.totalVendas));
        textpayment.setText("A prazo: "+ this.totPrazo+ "\nA vista: "+this.totVista);


        int indiceMaior=0;
        String[] tipos ={"utilitário","pickup", "sedan", "hatch", "esportivo", "trail", "street", "esportiva", "custom"};
        Integer[] totais ={this.utilitário,this.pickup, this.sedan, this.hatch, this.esportivo,this.trail, this.street, this.esportiva, this.custom};


        for(String s:tipos){
            System.out.println(s);
        }
        for(Integer s:totais){
            System.out.println(s);
        }


        for(int i=0;i< 9;i++){
            if(totais[i] > totais[indiceMaior]){
                indiceMaior=i;
            }
        }
        textmostpopularcar.setText("mais popular:"+tipos[indiceMaior]+ "com "+totais[indiceMaior] +" vendas.");
    }

    public String tipoMaisPopular(){
        /* Trail, Street, Esportivo, Custom, Carro: Utilitário, Sedan, Hatch, Esportivo */
        // Usar collections pra verificar o tipo mais frequente
        for(DesempenhoVendedor vendedores: listaDesempenho) {

        }
        int Trail = Collections.frequency(listaDesempenho, "Trail");
        int Street = Collections.frequency(listaDesempenho, "Street");
        int Esportivo = Collections.frequency(listaDesempenho, "Esportivo");
        int Custom = Collections.frequency(listaDesempenho, "Custom");
        int Utilitario = Collections.frequency(listaDesempenho, "Utilitario");
        int Sedan = Collections.frequency(listaDesempenho, "Sedan");
        int Hatch = Collections.frequency(listaDesempenho, "Hatch");

        stringsCount.put("Trail", Trail);
        stringsCount.put("Street", Street);
        stringsCount.put("Esportivo", Esportivo);
        stringsCount.put("Custom", Custom);
        stringsCount.put("Utilitario", Utilitario);
        stringsCount.put("Sedan", Sedan);
        stringsCount.put("Hatch", Hatch);

        int maxValueInMap=(Collections.max(stringsCount.values()));

       // Iterator<String> i = stringsCount.keySet().iterator();
        //while(i.hasNext()) {
       //     if(){

       //     }
      //  }
        return "";

    }
    public void close() {
        setVisible(false);
        dispose();
    }

    //////

    public void ler(){
        totalVendas=0;
        //ler vendas
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

                System.out.println("------------chegou aqui------------");
                System.out.println(nomeVendedor+" =="+ this.nomeVendedor);
                if(Objects.equals(nomeVendedor, this.nomeVendedor)){

                    System.out.println("if1");
                    this.totalVendas++;

                    if(Objects.equals(tipoPagamento, "A prazo")){

                        System.out.println("if2");
                        this.totPrazo++;
                    }else{
                        System.out.println("if3");
                        this.totVista++;
                    }




                    if(Objects.equals(tipoVeiculo, "utilitário")){
                        this.utilitário++;
                    }
                    else
                        if(Objects.equals(tipoVeiculo, "pickup")){
                        this.pickup++;
                    }
                    else
                    if(Objects.equals(tipoVeiculo, "sedan")){
                        this.sedan++;
                    }
                    else
                    if(Objects.equals(tipoVeiculo, "hatch")){
                        this.hatch++;
                    }
                    else
                    if(Objects.equals(tipoVeiculo, "esportivo")){
                        this.esportivo++;
                    }
                    else
                    if(Objects.equals(tipoVeiculo, "trail")){
                        this.trail++;
                    }
                    else
                    if(Objects.equals(tipoVeiculo, "street")){
                        this.street++;
                    }
                    else
                    if(Objects.equals(tipoVeiculo, "esportiva")){
                        this.esportiva++;
                    }
                    else
                    if(Objects.equals(tipoVeiculo, "custom")){
                        this.custom++;
                    }





                }


                for(String s: atributos){
                    System.out.println("atributos:\n"+s);
                }


            }
            myReader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }
    }
}

