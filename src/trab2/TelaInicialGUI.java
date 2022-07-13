package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaInicialGUI extends JFrame {
    private JPanel painelInicial;
    private JPanel PainelImagem;
    private JFrame frame;
    private JLabel displayField;
    private ImageIcon image;
    private JButton menuVendedorButton;
    private JButton menuGerenteButton;

    private JButton close;
    private JPasswordField senhaVendedor;
    private JLabel labelPic;
    private JPasswordField SenhaVendedor;
    private JPasswordField SenhaDoGerente;
    JTextField logingerente;
    static List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
    private JTextField loginvendedor;
    private int vendedorEscolhido;
    private static final String NOME_MESTRE_GERENTE = "admin";
    private static final String SENHA_MESTRE_GERENTE = "senha";
    private static final String SENHA_MESTRE_FUNCIONARIO = "senha";

    private static final String IMG_PATH = "src/Desktop.jpg";

    ImageIcon icon = new ImageIcon(IMG_PATH);


    public TelaInicialGUI(String title){
        super(title);
        labelPic.setText("");
        labelPic.setIcon(icon);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelInicial);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        ler();




        menuGerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPasswordField senhacripto = new JPasswordField(SENHA_MESTRE_GERENTE);
                System.out.println("aqui");
                if(Arrays.equals(SenhaDoGerente.getPassword(), senhacripto.getPassword())){
                    System.out.println("Senha Correta");
                    //apagar();
                    JFrame menuGerente = new MenuGerente();
                    close();
                }
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        menuVendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificarNomeESenha()){
                    MenuVendedor menuVendedor = new MenuVendedor(listaVendedores.get(vendedorEscolhido));
                    close();

                }
            }
        });
    }

    private void close(){
        setVisible(false);
        dispose();
    }
    private void apagar(){
        frame.setVisible(false);
    }

    public static void main(String[] args) throws IOException {

        JFrame frame = new TelaInicialGUI("Concessionária Jose");

    }


    public void ler(){

        //ler vendedores
        try{


            File arq = new File("vendedores.txt");
            Scanner myReader = new Scanner(arq);



            Vendedor tempVendedor;

            while(myReader.hasNextLine()){



                String leitura = myReader.nextLine();
                System.out.println("leitura:\n"+leitura);

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




                for(String s: atributos){
                    System.out.println("atrubutos:\n"+s);
                }

                //depois arrumar uma forma de passar o gerente correto, talvez buscar ele por rg
                Gerente gerenteGenerico= new Gerente("4325432-x","anderson",1,1,1,2,2,2,1000,0);
               tempVendedor = new Vendedor(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,ttrestante,gerenteGenerico,tsenha);
               listaVendedores.add(tempVendedor);



            }


            myReader.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }

    }

    public boolean verificarNomeESenha(){
        boolean resposta = false;
        int index=0;
        for(Vendedor v:listaVendedores){
          //  if(String.equals(v.getNome(), loginvendedor.getText() ) && Arrays.equals(v.getSenha(), senhaVendedor.getText() ) ){
          //      resposta = true;
           //}
            if(Objects.equals(v.getNome(), loginvendedor.getText()) && Objects.equals(v.getSenha(), senhaVendedor.getText())){
               vendedorEscolhido = index;
                resposta = true;
            }
            index++;
        }
        return resposta;
    }
}
