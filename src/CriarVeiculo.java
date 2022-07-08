import javax.swing.*;

public class CriarVeiculo extends JFrame {
    private JPanel principalFrame;

    public CriarVeiculo(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(principalFrame);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        CriarVeiculo c = new CriarVeiculo();
    }
}
