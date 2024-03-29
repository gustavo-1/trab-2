package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class AdicionarMotocicleta extends JFrame {
    private JTextField Nchassi;
    private JTextField marca;
    private JTextField ano;
    private JTextField tipoCombustivel;
    private JTextField quilometragem;
    private JPanel PainelAddMoto;
    private JButton adicionarMotoButton;
    private JButton close;
    private JTextField modelo;
    private JCheckBox vendidoCheckBox;
    private JLabel JLabelPeso;
    private JLabel JLabelStatus;
    private JLabel tipoDeCombustívelLabel;
    private JLabel JLabelAno;
    private JLabel JLabelModelo;
    private JLabel JLabelKM;
    private JLabel JLabelMarca;
    private JLabel JLabelNumero;
    private JTextField peso;
    private JTextField cilindradas;
    private JComboBox tipo;
    private JLabel JLabelNchassi;
    private JLabel cinlindradasLabel;
    private JLabel tipoLabel;
    private JLabel erroEntrada;
    private  Vendedor vendedor;
    private  int retornar;

    public AdicionarMotocicleta() {
        super("Adicionar Moto - Gerente");
        this.retornar=2;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelAddMoto);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        adicionarMotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adicionar();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
        //vendedor
        //
        public AdicionarMotocicleta(int retornar,Vendedor v){
            super("Adicionar Moto - Vendedor");
            this.retornar=retornar;
            this.vendedor =v;

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(PainelAddMoto);
            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);

            adicionarMotoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        adicionar();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuVendedor mv = new MenuVendedor(vendedor);
                close();
            }
        });
    }
 /////////////////////////////////////////////
    public static void main(String[] args) {
        AdicionarMotocicleta a = new AdicionarMotocicleta();
    }

    public void close(){
        setVisible(false);
        dispose();
    }
    public void adicionar() throws IOException {

        try{
        int nchaci = Integer.parseInt(Nchassi.getText());
        String tmarca = marca.getText();
        String tmodelo = modelo.getText();
        int tano= Integer.parseInt(ano.getText());
        double tquilometragem = Double.parseDouble(quilometragem.getText());
        String tTipoDeCombustivel = tipoCombustivel.getText();
        double tPeso = Double.parseDouble(peso.getText());
        boolean tVendido = vendidoCheckBox.isSelected();

        int tcilindradas = Integer.parseInt(cilindradas.getText());
        String ttipo  = Objects.toString(tipo.getSelectedItem());

        Motocicleta motoNova = new Motocicleta(nchaci,tmarca,tmodelo,tano,tquilometragem,tTipoDeCombustivel,tPeso,tVendido, tcilindradas,ttipo);

        //escreve em arquivo veiculo criado
        try{
            File arq = new File("motos.txt");
            FileWriter saida = new FileWriter(arq,true);

            String textoSaida =  nchaci + "~"+ tmarca+ "~" + tmodelo + "~"+ tano + "~"+ tquilometragem + "~"+tTipoDeCombustivel+ "~" + tPeso + "~"+ tVendido  +"~"+tcilindradas + "~"+ ttipo+"\n";

            saida.write(textoSaida);
            saida.close();

            if(this.retornar == 1){
                MenuVendedor mv = new MenuVendedor(vendedor);
                close();
            }else{
                MenuGerente mg = new MenuGerente();
                close();
            }
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }

        }catch (Exception e){
            erroEntrada.setVisible(true);
            System.out.println("--------------------------------erro-----------------------------"+e);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
