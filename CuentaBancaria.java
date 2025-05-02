/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unl.cc.poo.practica;

/**
 *
 * @author IVETT
 */
public class CuentaBancaria {

    //Atributos
    private String nombreTitular;
    private String numeroCuenta;
    private Float saldo;
    private String historial;
    private boolean cuentaActiva;

    //Constructor para inicializar las variables
    public CuentaBancaria() {
        this.saldo = 0.00f;
        this.cuentaActiva = false;
        this.historial = " ";
        this.numeroCuenta = "29" + String.format("%010d", (long) (Math.random() * 1_000_000_0000L)); //Genera un número aleatorio;
    }

    //Método para verificar que el usuario tengo una cuenta activa
    public boolean verificarCuentaActiva() {
        return cuentaActiva;
    }

    //Método para generar una cuenta
    public void generarNuevaCuenta(String nombre) {
        this.nombreTitular = nombre;
        this.saldo = 0.00f;
        this.cuentaActiva = true;
        historial += "--> Historial de transacciones de " + nombre;
    }

    //Método para depositar
    public void depositar(float monto) {
        if (monto > 0) {
            saldo += monto;
            historial += "\n Depósito: +$" + monto; //Para que se guarde en el historial
        } else {

        }
    }

    //Método para retirar
    public void retirar(float monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            historial += "\n Retiro: -$" + monto;
        }
    }

    //Sirve para consultar el historial
    public String consultarHistorial() {
        System.out.println(toString()); //toString + historial
        return historial;
    }

    //Getters y Setters
    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    //to String
    @Override
    public String toString() {
        if (cuentaActiva) {
            return "--> Datos"
                    + "\nTitular: " + nombreTitular + "\n"
                    + "Número de cuenta: " + numeroCuenta + "\n"
                    + "Saldo actual: " + saldo + "\n";
        } else {
            return "Usted no posee una cuenta, crea la cuenta primero";
        }
    }
}
