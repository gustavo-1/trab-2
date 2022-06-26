package trab2;

public class Dimensoes{
    private double altura;
    private double largura;
    private double comprimento;

    public Dimensoes(double a, double l, double c){
        this.altura =a;
        this.largura=l;
        this.comprimento = c;
    }
    public double getAltura() {
        return altura;
    }
    public double getComprimento() {
        return comprimento;
    }
    public double getLargura() {
        return largura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
    public void setLargura(double largura) {
        this.largura = largura;
    }
    
}