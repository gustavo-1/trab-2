package trab2;
public class Vendedor extends Funcionario {
    private double tempoRestante;
    private Gerente gerente;

    public Vendedor(String r, Data dn,Data da, double s,double t, Gerente g){
        super(r, dn, da, s);
        this.tempoRestante = t;
        this.gerente = g;
    }
    
    public double getTempoRestante() {
        return tempoRestante;
    }
    public Gerente getGerente() {
        return gerente;
    }
  
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    public void setTempoRestante(double tempoRestante) {
        this.tempoRestante = tempoRestante;
    }
    
}
