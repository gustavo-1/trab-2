package trab2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdicionarCarro extends JFrame {
    private JTextField marca;
    private JTextField ano;
    private JTextField tipoCombustivel;
    private JTextField quilometragem;
    private JPanel PainelAddCarro;
    private JTextField Nchassi;
    private JLabel númeroDoChassiLabel;
    private JButton AddCarro;
    private JButton close;
    private JTextField modelo;
    private JCheckBox vendidoCheckBox;
    private JLabel JLabelPeso;
    private JLabel JLabelAno;
    private JLabel JLabelModelo;
    private JLabel JLabelKM;
    private JLabel JLabelMarca;
    private JLabel JLabelNumero;
    private JTextField peso;
    private JTextField potencia;
    private JTextField nCilindros;
    private JTextField nOcupantes;
    private JTextField tipo;
    private JLabel tipoDeCombustívelLabel;
    private JTextField altura;
    private JTextField largura;
    private JTextField comprimento;
    private JLabel comprimentoLabel;
    private JLabel larguraLabel;
    private JLabel alturaLabel;
    private JLabel tipoLabel;
    private JLabel númeroDeOcupantesLabel;
    private JLabel númeroDeCilindrosLabel;
    private JLabel potenciaLabel;
    private JLabel statusLabel;
    private Vendedor vendedor;
    private int retornar;

    public AdicionarCarro(){
        super("Adicionar Carro - Gerente");
        this.retornar =2;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelAddCarro);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        AddCarro.addActionListener(new ActionListener() {
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

    //veio do vendedor
    public AdicionarCarro(int retornar,Vendedor v){
        super("Adicionar Carro - Vendedor");
        this.retornar = retornar;
        this.vendedor = v;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PainelAddCarro);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        AddCarro.addActionListener(new ActionListener() {
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
                AdicionarVeiculo f = new AdicionarVeiculo(1,v);
                close();
            }
        });
    }

    public static void main(String[] args) {
        AdicionarCarro a = new AdicionarCarro();
    }

    private void close(){
        setVisible(false);
        dispose();
    }
    public void adicionar() throws IOException {
        int nchassi = Integer.parseInt(Nchassi.getText());
        String tmarca = marca.getText();
        String tmodelo = modelo.getText();
        int tano = Integer.parseInt(ano.getText());
        double tquilometragem = Double.parseDouble(quilometragem.getText());
        String tTipoDeCombustivel = tipoCombustivel.getText();
        double tPeso = Double.parseDouble(peso.getText());
        boolean tVendido = vendidoCheckBox.isSelected();

        int tpotencia = Integer.parseInt(potencia.getText());
        int tnDeCilindros = Integer.parseInt(nCilindros.getText());
        int tnDeOcupantes = Integer.parseInt(nOcupantes.getText());
        String ttipo  = tipo.getText();
        double talt= Double.parseDouble(altura.getText());
        double tlarg= Double.parseDouble(largura.getText());
        double tcompri= Double.parseDouble(comprimento.getText());

        //informações especificas sobre carro ou moto ainda não foram adicionadas pra eu poder comecar a testar
        Carro carroNovo = new Carro(nchassi,tmarca,tmodelo,tano,tquilometragem,tTipoDeCombustivel,tPeso,tVendido,tpotencia,tnDeCilindros,tnDeOcupantes,ttipo,talt,tlarg,tcompri);

        //escreve em arquivo veiculo criado
        try{
            //BufferedWriter saida = new BufferedWriter(new FileWriter("carros.txt"));

            File arq = new File("carros.txt");
            FileWriter saida = new FileWriter(arq,true);


            String textoSaida =  nchassi + "~"+ tmarca+ "~" + tmodelo + "~"+ tano + "~"+ tquilometragem + "~"+tTipoDeCombustivel+ "~" + tPeso + "~"+ tVendido  +"~"+tpotencia +"~"+tnDeCilindros+ "~" +tnDeOcupantes +"~"+ ttipo  +"~"+talt +"~"+tlarg+ "~" + tcompri+"\n";
            saida.write(textoSaida);

            saida.close();

            if(this.retornar ==2){

                MenuGerente mg = new MenuGerente();
                close();
            }else{
                MenuVendedor mv = new MenuVendedor(vendedor);
                close();
            }
        }
        catch (IOException e){
            System.out.println("Erro: " + e);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
