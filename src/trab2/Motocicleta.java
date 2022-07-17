package trab2;
public class Motocicleta extends Veiculo {
    private int cilindradas;
    private String tipo; /* trail, street, esportivo, custom */


    public Motocicleta(int n,String ma, String mo, int a, double k, String t, double p,boolean v, int cil, String tip){
        super(n, ma, mo, a, k, t, p, v);
        this.cilindradas = cil;
        this.tipo = tip;

    }
    public int getCilindradas() {
        return cilindradas;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}
