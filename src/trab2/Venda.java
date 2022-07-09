package trab2;
public class Venda {
    private int id;
    private Vendedor vendedor;
    private Cliente cliente;
    private Veiculo veiculo;//por enquanto é um veiculo, mas no futuro devera ser so um carro ou moto, nunca a classe pai, que nao pode ser instanciada
    private double valor;
    private Data data;
    private Horario horario;

    public Venda(int id, Vendedor vendedor, Cliente cliente, Veiculo veiculo, double valor, int dia, int mes, int ano,int hora, int minutos){
        this.id = id;
        this.vendedor= vendedor;
        this.cliente= cliente;
        this.veiculo = veiculo;
        this.valor=valor;
        this.data = new Data(dia, mes, ano);
        horario = new Horario(hora,minutos);

    }
    public Cliente getCliente() {
        return cliente;
    }
    public Data getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setData(Data data) {
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
