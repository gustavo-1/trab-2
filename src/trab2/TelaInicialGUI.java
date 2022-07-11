package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

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
    private JPasswordField senhaGerentePasswordField;
    private JLabel labelPic;
    private JPasswordField SenhaVendedor;
    JTextField logingerente;
    private JTextField loginvendedor;
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


        menuVendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* System.out.println("aqui");
                if(Arrays.equals(SenhaVendedor.getPassword(), (.........).getPassword())){ // Senha guardada no banco de dados após o cadastro
                    System.out.println("Senha Correta");
                    //apagar();
                    JFrame menuVendedor = new menuVendedor();
                }
                close();*/
            }
        });
        menuGerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPasswordField senhacripto = new JPasswordField(SENHA_MESTRE_GERENTE);
                System.out.println("aqui");
                if(Arrays.equals(SenhaVendedor.getPassword(), senhacripto.getPassword())){
                    System.out.println("Senha Correta");
                    //apagar();
                    JFrame menuGerente = new menuGerente();
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

}
