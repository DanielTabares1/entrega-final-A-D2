package modelo;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Random;

public class Tarjeta {

    private static String BANK_IDENTIFIER_NUMBER = "534251";

    private String idTitular;
    private String nombreTitular;
    private String pan;
    private String bin;
    private String iai;
    private String check;
    private String pin;
    private String cvv;
    private String fechaExpedicion;
    private String fechaCaducidad;
    private String tipo;
    private String marca;
    private String numeroCuenta;
    private String estado;

    public Tarjeta(Cliente cliente, String pin, String tipo, String marca) {
        this.nombreTitular = cliente.getNombre();
        this.idTitular = cliente.getId();
        this.tipo = tipo;
        this.marca = marca;
        this.bin = BANK_IDENTIFIER_NUMBER;
        this.iai = generarNumero(9);
        this.check = generarNumero(1);
        this.pan = this.bin + this.iai + this.check;
        this.cvv = generarNumero(3);
        this.fechaExpedicion = LocalDate.now().toString();
        this.fechaCaducidad = LocalDate.now().plusYears(5).toString();
        this.pin = pin;
        this.estado = "Activo";
    }


    //                    GETTERS AND SETTERS

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getIdTitular() {
        return this.idTitular;
    }

    public String getPan() {
        return pan;
    }

    public String getBin() {
        return bin;
    }

    public String getIai() {
        return iai;
    }

    public String getCheck() {
        return check;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCvv() {
        return cvv;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    //método auxiliar para asignar los números
    //en un banco real tiene otra lógica de negocio

    public String generarNumero(int i) {
        StringBuilder s = new StringBuilder();
        Random r = new Random();
        for (int j = 0; j < i; j++) {
            s.append(r.nextInt(10));
        }
        return s.toString();
    }

}
