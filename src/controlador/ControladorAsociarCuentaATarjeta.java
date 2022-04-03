package controlador;

import DAO.CuentasDAOtxt;
import DAO.TarjetasDAOtxt;
import modelo.Cuenta;
import modelo.Tarjeta;

import javax.swing.*;

public class ControladorAsociarCuentaATarjeta {

    private String numeroDeCuenta;
    private String panTarjeta;
    private Cuenta cuenta;
    private Tarjeta tarjeta;

    public ControladorAsociarCuentaATarjeta(){
        this.numeroDeCuenta = JOptionPane.showInputDialog("Digite el numero de cuenta a asociar");
        this.panTarjeta = JOptionPane.showInputDialog("Digite el número de su tarjeta");
        this.tarjeta = capturarTarjeta(this.panTarjeta);
        this.cuenta = capturarCuenta(this.numeroDeCuenta);

        asociarCuentaATarjeta();

    }

    private Cuenta capturarCuenta(String numeroDeCuenta){
        return CuentasDAOtxt.getInstance().buscarCuenta(numeroDeCuenta);
    }

    private Tarjeta capturarTarjeta(String panTarjeta){
        return TarjetasDAOtxt.getInstance().buscarTarjeta(panTarjeta);
    }

    private void asociarCuentaATarjeta(){
        this.tarjeta.setNumeroCuenta(this.cuenta.getNumeroDeCuenta());
        TarjetasDAOtxt.getInstance().registrarTarjeta(this.tarjeta);
        //todo.... modificar para que modifique la tarjeta en lugar de crear una nueva
    }





}
