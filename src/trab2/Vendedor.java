package trab2;
public class Vendedor extends Funcionario {
    private double tempoRestante;
    private Gerente gerente;
    private String senha;
    public Vendedor(String r, String nome, int dia, int mes, int ano,int diae, int mese,int anoe, double s, double t, Gerente g,String senha){
        super(r, nome,dia,mes,ano,diae,mese,anoe, s);
        this.tempoRestante = t;
        this.gerente = g;
        this.senha = senha;
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
    public String getSenha() {
        return senha;
    }
}
