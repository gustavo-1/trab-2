import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

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







        //////////////////// tenta printar todos atrubutos automatiamente(sou preguicoso não quero escrever )
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append( carroNovo.getClass().getName() );
        result.append( " Object {" );
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = carroNovo.getClass().getDeclaredFields();

        //print field names paired with their values
        for ( Field field : fields  ) {
            result.append("  ");
            try {
                result.append( field.getName() );
                result.append(": ");
                //requires access to private field:
                result.append( field.get(carroNovo) );
            } catch ( IllegalAccessException ex ) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        System.out.println(result.toString());

        /////////////////////////
        ///escreve na mão(aceitei derrota)

        try{
            //BufferedWriter saida = new BufferedWriter(new FileWriter("carros.txt"));

            File arq = new File("carros.txt");
            FileWriter saida = new FileWriter(arq,true);


            String textoSaida = nchaci + "|" ;
            saida.write(textoSaida+"\n");



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
