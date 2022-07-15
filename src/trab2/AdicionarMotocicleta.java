package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    private JTextField tipo;
    private JLabel JLabelNchassi;
    private JLabel cinlindradasLabel;
    private JLabel tipoLabel;

    public AdicionarMotocicleta(){
        super("Menu - Gerente");

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
                AdicionarVeiculo f = new AdicionarVeiculo();
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
        int nchaci = Integer.parseInt(Nchassi.getText());
        String tmarca = marca.getText();
        String tmodelo = modelo.getText();
        int tano= Integer.parseInt(ano.getText());
        double tquilometragem = Double.parseDouble(quilometragem.getText());
        String tTipoDeCombustivel = tipoCombustivel.getText();
        double tPeso = Double.parseDouble(peso.getText());
        boolean tVendido = vendidoCheckBox.isSelected();

        int tcilindradas = Integer.parseInt(cilindradas.getText());
        String ttipo  = tipo.getText();

        //informações especificas sobre carro ou moto ainda não foram adicionadas pra eu poder comecar a testar
        Motocicleta motoNova = new Motocicleta(nchaci,tmarca,tmodelo,tano,tquilometragem,tTipoDeCombustivel,tPeso,tVendido, tcilindradas,ttipo);








        //escreve em arquivo veiculo criado
        try{
            //BufferedWriter saida = new BufferedWriter(new FileWriter("carros.txt"));

            File arq = new File("motos.txt");
            FileWriter saida = new FileWriter(arq,true);


            String textoSaida =  nchaci + "~"+ tmarca+ "~" + tmodelo + "~"+ tano + "~"+ tquilometragem + "~"+tTipoDeCombustivel+ "~" + tPeso + "~"+ tVendido  +"~"+tcilindradas + "~"+ ttipo+"\n";
            saida.write(textoSaida);



            saida.close();
        }
        catch (IOException e){
            System.out.println("erro: "+e);
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
