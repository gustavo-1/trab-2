public class Venda {
    private int id;
    private Vendedor vendedor;
    private Cliente cliente;
    private Veiculo veiculo;//por enquanto é um veiculo, mas no futuro devera ser so um carro ou moto, nunca a classe pai, que nao pode ser instanciada
    private double valor;
    private Data data;
    private int hora;
    private int minutos;

    public Venda(int id, Vendedor vendedor, Cliente cliente, Veiculo veiculo, double valor, int dia, int mes, int ano,int hora, int minutos){
        this.id = id;
        this.vendedor= vendedor;
        this.cliente= cliente;
        this.veiculo = veiculo;
        this.valor=valor;
        this.data = new Data(dia, mes, ano);
        this.hora=hora;
        this.minutos = minutos;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Data getData() {
        return data;
    }
    public int getHora() {
        return hora;
    }
    public int getId() {
        return id;
    }
    public int getMinutos() {
        return minutos;
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
    public void setHora(int hora) {
        this.hora = hora;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
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
}
