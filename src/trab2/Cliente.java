package trab2;
public class Cliente {
    private int cpf;
    private String nome;
    private Data nascimento;
    private String rua;
    private int nrua;
    private String bairro;
    private String cidade;
    private double renda;
    private int dependentes;//perguntar se é o numero de dependentes ou objetos que identificam os dependentes

    public Cliente(int cpf, String nome, int dia, int mes, int ano, String rua, int nrua, String bairro, String cidade, double renda ,int dependentes){
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = new Data(dia, mes, ano);
        this.rua = rua;
        this.nrua = nrua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.renda=renda;
        this.dependentes = dependentes;
    }
    public int getCpf() {
        return cpf;
    }
    public int getDependentes() {
        return dependentes;
    }

    public String getRua() {
        return rua;
    }

    public int getNrua() {
        return nrua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public Data getNascimento() {
        return nascimento;
    }
    public String getNome() {
        return nome;
    }
    public double getRenda() {
        return renda;
    }
    public void setRenda(double renda) {
        this.renda = renda;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNrua(int nrua) {
        this.nrua = nrua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNascimento(Data nascimento) {
        this.nascimento = nascimento;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    
}
