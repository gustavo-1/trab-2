package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
    private String nomeseller;
    static List <DesempenhoVendedor> listaDesempenho= new ArrayList<DesempenhoVendedor>();

     public Desempenho(String nomeseller){
        ler();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(paineldesempenho);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        textvendedor.setText(nomeseller);

        texteqtdvendas.setText(mostRepeatedWord);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuGerente mg = new MenuGerente();
                close();
            }
        });

    }

    public void tipoMaisPopular(){
        /* Trail, Street, Esportivo, Custom, Carro: Utilitário, Sedan, Hatch, Esportivo */
        // Usar collections pra verificar o tipo mais frequente
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

                DesempenhoVendedor tempDesempenho = new DesempenhoVendedor(tid, nomeseller, cpf, tipoVeiculo, tipoPagamento);
                listaDesempenho.add(tempDesempenho);

            }
            myReader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }
    }
}

