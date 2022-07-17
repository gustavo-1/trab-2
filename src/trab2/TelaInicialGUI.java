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
    static List<Gerente> listaGerentes = new ArrayList<Gerente>();
    private JTextField loginvendedor;
    private JLabel LoginErrado;
    private int vendedorEscolhido;
    private int gerenteEscolhido;
    private static final String SENHA_MESTRE_GERENTE = "senha";

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

                if(Arrays.equals(SenhaDoGerente.getPassword(), senhacripto.getPassword())){
                    JFrame menuGerente = new MenuGerente();
                    close();
                }
                else if(verificarNomeESenhaGerente()){
                    MenuGerente menuGerente= new MenuGerente();
                    close();

                }
                else{
                    LoginErrado.setVisible(true);
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
                else{
                    LoginErrado.setVisible(true);
                }
            }
        });
    }

    private void close(){ // Fechar janela
        setVisible(false);
        dispose();
    }
    private void apagar(){
        frame.setVisible(false);
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new TelaInicialGUI("Concessionária José");
    }

    public void ler(){

        // Ler as informações dos vendedores salvos no arquivo vendedores.txt
        try{

            File arq = new File("vendedores.txt");
            Scanner myReader = new Scanner(arq);

            Vendedor tempVendedor;

            while(myReader.hasNextLine()){
                String leitura = myReader.nextLine();
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
                String tsenha  = atributos[11];

                Gerente gerenteGenerico= new Gerente("4325432-x","anderson",1,1,1,2,2,2,1000,0,"senhaGenerica");
               tempVendedor = new Vendedor(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,ttrestante,gerenteGenerico,tsenha);
               listaVendedores.add(tempVendedor);

            }

            myReader.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }

        // Ler os gerentes salvos no arquivo gerentes.txt

        try{
            File arq = new File("gerentes.txt");
            Scanner myReader2 = new Scanner(arq);

            Vendedor tempVendedor;

            while(myReader2.hasNextLine()){
                String leitura = myReader2.nextLine();
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
                Gerente gerenteGenerico = new Gerente(trg,tnome,tdiaNasc,tdmesNasc,tanoNasc,tdiaAd,tdmesAd,tdanoAd,tsalario,tanosExp,tsenha);
                listaGerentes.add(gerenteGenerico);

            }
            myReader2.close();
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }
    }

    public boolean verificarNomeESenha(){ // Sistema de login para vendedores
        boolean resposta = false;
        int index=0;
        for(Vendedor v:listaVendedores){
            if(Objects.equals(v.getNome(), loginvendedor.getText()) && Objects.equals(v.getSenha(), senhaVendedor.getText())){
               vendedorEscolhido = index;
                resposta = true;
            }
            index++;
        }
        return resposta;
    }
    public boolean verificarNomeESenhaGerente(){ // Sistema de login para gerentes
        boolean resposta = false;
        int index=0;
        for(Gerente v:listaGerentes){
            System.out.println("v: Nome: "+ v.getNome()+ "  Senha: "+v.getSenha());
            if(Objects.equals(v.getNome(), logingerente.getText()) && Objects.equals(v.getSenha(), SenhaDoGerente.getText())){
                gerenteEscolhido = index;
                resposta = true;
                System.out.println("Gerente encontrado");
            }
            index++;
        }
        return resposta;
    }
}
