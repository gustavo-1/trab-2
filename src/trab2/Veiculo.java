package trab2;

public abstract class Veiculo{
    protected int numeroDoChassi;
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double km;
    protected String tipoCombustivel;
    protected double peso;
    protected boolean vendido;


    public Veiculo(int n,String ma, String mo, int a, double k, String t, double p,boolean v){
       this.numeroDoChassi = n;
       this.marca = ma;
       this.modelo = mo;
       this.ano=a;
       this.km=k;
       this.tipoCombustivel = t;
       this.peso = p;
       this.vendido=v;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setKm(double km) {
        this.km = km;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setNumeroDoChassi(int numeroDoChassi) {
        this.numeroDoChassi = numeroDoChassi;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
    public int getAno() {
        return ano;
    }
    public double getKm() {
        return km;
    }
    public String getMarca() {
        return marca;
    }public String getModelo() {
        return modelo;
    }
    public int getNumeroDoChassi() {
        return numeroDoChassi;
    }
    public double getPeso() {
        return peso;
    }
    public String getTipoCombustivel() {
        return tipoCombustivel;
    }



}