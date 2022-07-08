public class Cliente {
    private int cpf;
    private String nome;
    private Data nascimento;
    private String endereco;
    private double renda;
    private int dependentes;//perguntar se é o numero de dependentes ou objetos que identificam os dependentes

    public Cliente(int cpf, String nome, int dia, int mes, int ano, String endereco, double renda ,int dependentes){
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = new Data(dia, mes, ano);
        this.endereco = endereco;
        this.renda=renda;
        this.dependentes = dependentes;


    }
    public int getCpf() {
        return cpf;
    }
    public int getDependentes() {
        return dependentes;
    }
    public String getEndereco() {
        return endereco;
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
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setNascimento(Data nascimento) {
        this.nascimento = nascimento;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
