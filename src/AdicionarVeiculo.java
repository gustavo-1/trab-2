import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class AdicionarVeiculo extends JFrame {
    private JTextField Nchaci;
    private JTextField marca;
    private JTextField ano;
    private JTextField tipoCombustivel;
    private JTextField quilometragem;
    private JPanel Painel;
    private JButton button1;
    private JTextField modelo;
    private JTextField peso;
    private JCheckBox vendidoCheckBox;
    private JLabel JLabelPeso;
    private JLabel JLabelStatus;
    private JLabel JLabelTipo;
    private JLabel JLabelAno;
    private JLabel JLabelModelo;
    private JLabel JLabelKM;
    private JLabel JLabelMarca;
    private JLabel JLabelNumero;

    public AdicionarVeiculo(){
        super("menu vendedor");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(Painel);
        this.pack();
        this.setVisible(true);

        button1.addActionListener(new ActionListener() {
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

    public static void main(String[] args) {
        AdicionarVeiculo a = new AdicionarVeiculo();
    }


    public void adicionar() throws IOException {
        int nchaci = Integer.parseInt(Nchaci.getText());
        //String tmarca = marca.getText();
       // String tmodelo = modelo.getText();
       // int tano= Integer.parseInt(ano.getText());
        //double tquilometragem = Double.parseDouble(quilometragem.getText());
       // String tTipoDeCombustivel = tipoCombustivel.getText();
        //double tPeso = Double.parseDouble(peso.getText());
        ///boolean tVendido = vendidoCheckBox.isSelected();

            //informações especificas sobre carro ou moto ainda não foram adicionadas pra eu poder comecar a testar
        Carro carroNovo = new Carro(nchaci,"tmarca","tmodelo",1,1.1,"tTipoDeCombustivel",1.1,true,0,0,0," ",0.0,0.0,0.0);

        try{
            BufferedWriter saida = new BufferedWriter(new FileWriter("carros.txt"));

            String textoSaida = nchaci + "|" ;
            saida.write(textoSaida);
            saida.newLine();


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
