package trab2;
public abstract class Funcionario{
    protected String rg;
    protected String nome;
    protected Data dataNascimento;
    protected Data dataAdmissao; 
    protected double salario;

    public Funcionario(String r, String nome, int dia, int mes, int ano,int diae, int mese,int anoe, double s){
        this.rg=r;
        this.dataNascimento = new Data(dia,mes,ano);
        this.dataAdmissao= new Data(diae,mese,anoe);
        this.salario = s;
        this.nome = nome;
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
    public String getNome() {
        return nome;
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

    public void setNome(String nome) {
        this.nome = nome;
    }
}