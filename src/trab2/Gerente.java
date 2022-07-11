package trab2;
public class Gerente extends Funcionario {
    private int anosDeExperiencia;

    public Gerente(String r, String nome,  int dia, int mes, int ano,int diae, int mese,int anoe, double s, int a){
        super(r, nome, dia,mes,ano,diae,mese,anoe, s);
        this.anosDeExperiencia=a;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        this.anosDeExperiencia = anosDeExperiencia;
    }
    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }
}