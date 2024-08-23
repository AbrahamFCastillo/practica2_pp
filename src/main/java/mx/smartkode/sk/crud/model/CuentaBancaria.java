package mx.smartkode.sk.crud.model;

public class CuentaBancaria {
    public Integer id;
    private String titular;
    private Double saldo;
    private String tipoCuenta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) { 
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancaria [titular=" + titular + ", saldo=" + saldo + ", tipoCuenta=" + tipoCuenta + "]";
    }
}

