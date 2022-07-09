import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuGerente extends JFrame{

    private JPanel painelGerente;
    private JButton veiculoButton;
    private JButton clienteButton;
    private JButton button3;
    private JButton venderButton;

    public menuGerente(){
        super("menu gerente");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelGerente);
        this.pack();
        this.setVisible(true);

        veiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irParaAdicionarVeiculo();
            }
        });
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irParaAdicionarCliente();
            }
        });
    }
    public void irParaAdicionarVeiculo(){
        AdicionarVeiculo f = new AdicionarVeiculo();

    }
    public void irParaAdicionarCliente(){
        AdicionarCliente f = new AdicionarCliente();

    }
}
