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
    Map<String, Integer> stringsCount = new HashMap<>();

    public Desempenho(String nomevendedor){
        ler();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(paineldesempenho);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        textvendedor.setText(nomevendedor);
        textmostpopularcar.setText(tipoMaisPopular().toString());
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGerente mg = new MenuGerente();
                close();
            }
        });

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

        Iterator<String> i = stringsCount.keySet().iterator();
        while(i.hasNext()) {
            if(){

            }
        }

    }
    public void close() {
        setVisible(false);
        dispose();
    }

    //////

    public void ler(){

        //ler vendedor
        try{
            File arq = new File("vendas.txt");
            Scanner myReader = new Scanner(arq);
            //BufferedReader leitor = new BufferedReader(arq);

            Vendedor tempVendedor;

            while(myReader.hasNextLine()){

                String leitura = myReader.nextLine();
                System.out.println("Leitura: \n" + leitura);

                String[] atributos = leitura.split("~");


                int tid = Integer.parseInt(atributos[0]);
                String nomeseller = atributos[1];
                String tipoVeiculo = atributos[2];
                int cpf = Integer.parseInt(atributos[2]);
                String tipoPagamento = atributos[10];

                for(String s: atributos){
                    System.out.println("atributos:\n"+s);
                }

                Vendedor vendedor = this.vendedor;
                if(Objects.equals(nomeseller, nomevendedor)){
                    DesempenhoVendedor tempDesempenho = new DesempenhoVendedor(tid, nomeseller, cpf, tipoVeiculo, tipoPagamento);
                    listaDesempenho.add(tempDesempenho);
                }
            }
            myReader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }
    }
}

