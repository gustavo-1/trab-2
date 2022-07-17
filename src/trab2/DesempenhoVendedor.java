package trab2;

public class DesempenhoVendedor{

    private int tid;
    private String nomeseller;
    private int cpf;
    private String tipoVeiculo;
    private String tipoPagamento;

    public DesempenhoVendedor(int tid, String nomeseller, int cpf, String tipoVeiculo, String tipoPagamento) {
        this.tid = tid;
        this.nomeseller = nomeseller;
        this.cpf = cpf;
        this.tipoVeiculo = tipoVeiculo;
        this.tipoPagamento = tipoPagamento;
    }

    public int getTid() {
        return tid;
    }

    public String getNomeseller() {
        return nomeseller;
    }

    public int getCpf() {
        return cpf;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setNomeseller(String nomeseller) {
        this.nomeseller = nomeseller;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

}
