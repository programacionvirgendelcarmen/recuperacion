package RA5;

public class CuentaPersonal {
    //numeroTarjeta,numeroCuenta,moneda,saldo
    private String numeroTarjeta;
    private String numeroCuenta;
    private String moneda;
    private double saldo;

    public CuentaPersonal(String numeroTarjeta, String numeroCuenta,
                          String moneda, double saldo) {
        this.numeroTarjeta = numeroTarjeta;
        this.numeroCuenta = numeroCuenta;
        this.moneda = moneda;
        this.saldo = saldo;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%.2f", numeroTarjeta,
                numeroCuenta, moneda, saldo);
    }
}
