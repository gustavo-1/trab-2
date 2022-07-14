package trab2;
public class Gerente extends Funcionario {
    private int anosDeExperiencia;
    private String senha;


    public Gerente(String r, String nome,  int dia, int mes, int ano,int diae, int mese,int anoe, double s, int a,String senha){
        super(r, nome, dia,mes,ano,diae,mese,anoe, s);
        this.anosDeExperiencia=a;
        this.senha = senha;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        this.anosDeExperiencia = anosDeExperiencia;
    }
    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }

    public String getSenha() {
        return senha;
    }
}