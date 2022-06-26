package trab2;

public class Carro extends Veiculo {
    private int potencia;
    private int nDeCilindros;
    private int nDeOcupantes;
    private String tipo;
    private Dimensoes dimensoes;

    public Carro(int n,String ma, String mo, int a, double k, String t, double p,boolean v, int po, int nDeCil, int nDeOcu, String tip, double alt, double larg, double comp){
        super(n, ma, mo, a, k, t, p, v);
        this.potencia = po;
        this.nDeCilindros = nDeCil;
        this.nDeOcupantes = nDeOcu;
        this.tipo = tip;
        this.dimensoes = new Dimensoes(alt, larg, comp);

    }

    public int getPotencia() {
        return potencia;
    }
    public int getnDeCilindros() {
        return nDeCilindros;
    }
   public int getnDeOcupantes() {
       return nDeOcupantes;
   }
   public Dimensoes getDimensoes() {
       return dimensoes;
   }
   public String getTipo() {
       return tipo;
   }
   public void setPotencia(int potencia) {
       this.potencia = potencia;
   }
   public void setDimensoes(Dimensoes dimensoes) {
       this.dimensoes = dimensoes;
   }
   public void setnDeCilindros(int nDeCilindros) {
       this.nDeCilindros = nDeCilindros;
   }public void setnDeOcupantes(int nDeOcupantes) {
       this.nDeOcupantes = nDeOcupantes;
   }
   public void setTipo(String tipo) {
       this.tipo = tipo;
   }
}
