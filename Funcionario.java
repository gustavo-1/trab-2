public class Funcionario{
    protected String rg;
    protected Data dataNascimento;
    protected Data dataAdmissao; 
    protected double salario;   

    public Funcionario(String r, Data dn,Data da, double s){
        this.rg=r;
        this.dataNascimento = dn;
        this.dataAdmissao= da;
        this.salario = s;
    }

    public Data getDataAdmissao() {
        return dataAdmissao;
    }
    public Data getDataNascimento() {
        return dataNascimento;
    }
    public String getRg() {
        return rg;
    }
    public double getSalario() {
        return salario;
    }
    public void setDataAdmissao(Data dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

}