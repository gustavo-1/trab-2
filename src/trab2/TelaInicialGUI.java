package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaInicialGUI extends JFrame {
    private JPanel painelInicial;
    private JPanel PainelImagem;
    private JFrame frame;
    private JLabel displayField;
    private ImageIcon image;
    private JButton menuGerenteButton;
    private JButton menuVendedorButton;
    private JPasswordField senhaGerentePasswordField;
    private JLabel labelPic;
    private JPasswordField senhaGerentePasswordField1;
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
        this.setVisible(true);

        menuGerenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menuVendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("aqui");
                if(senhaGerentePasswordField.getText().equals(SENHA_MESTRE_GERENTE) == true){
                    System.out.println("Senha Correta");
                    //apagar();
                    JFrame menuGerente = new menuGerente();
                }

            }
        });
    }
    private void apagar(){
        frame.setVisible(false);
    }

    public static void main(String[] args) throws IOException {

        JFrame frame = new TelaInicialGUI("Consecionaria Jose");


    }


}
