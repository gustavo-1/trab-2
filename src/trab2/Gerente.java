package trab2;
public class Gerente extends Funcionario {
    private int anosDeExperiencia;

    public Gerente(String r, Data dn,Data da, double s, int a){
        super(r, dn, da, s);
        this.anosDeExperiencia=a;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        this.anosDeExperiencia = anosDeExperiencia;
    }
    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }
}
