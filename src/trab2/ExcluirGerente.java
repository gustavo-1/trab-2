package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcluirGerente extends JFrame {
    private JPanel PainelApagarGerente;
    private JButton removerFuncionarioButton;
    private JList list1;
    public List<Gerente> listaGerentes = new ArrayList<Gerente>();
    private JButton close;
    public ExcluirGerente(){
        listaGerentes.clear();
        ler();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelApagarGerente);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        DefaultListModel modeloVendedor = criaModeloGerente();
        list1.setModel(modeloVendedor);


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

    public static void main(String[] args) {
        ExcluirGerente ex = new ExcluirGerente();
    }

    public void clicou(){

        System.out.println("escolido: "+list1.getSelectedIndex());
        int resposta1 = list1.getSelectedIndex();

        //agora deve se remover a linha selecionada
        try {
            File inputFile = new File("gerentes.txt");
            File tempFile = new File("gerentes2.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            for(int i=0;i< listaGerentes.size();i++){
                currentLine = reader.readLine();

                if(i != this.list1.getSelectedIndex()){
                    writer.write(currentLine);
                }
            }

            writer.close();
            reader.close();

            //le clientes2 de novo e salva tudo na string
            File vendedores2 = new File("gerentes2.txt");
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
            File novoVendedor = new File("gerentes.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter( novoVendedor));
            escritor.write(textoCompleto);

            escritor.close();

            //apaga cliente2.txt
            vendedores2.delete();

        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }
        ///////////////////
        MenuGerente mg = new MenuGerente();
        close();
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

                Gerente gerenteGenerico = new Gerente(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,tanosExp,tsenha);
                listaGerentes.add(gerenteGenerico);
            }
            myReader2.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }
    }
    public DefaultListModel criaModeloGerente(){
        DefaultListModel modelo = new DefaultListModel();
        String temp;
        for(Gerente c: listaGerentes){
            temp = "nome:"+c.getNome()+" cpf:" + c.getRg();
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
