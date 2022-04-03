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

    public ControladorAsociarCuentaATarjeta() {
        this.numeroDeCuenta = JOptionPane.showInputDialog("Digite el numero de cuenta a asociar");
        this.panTarjeta = JOptionPane.showInputDialog("Digite el número de su tarjeta");
        this.tarjeta = capturarTarjeta(this.panTarjeta);
        this.cuenta = capturarCuenta(this.numeroDeCuenta);

        if (this.cuenta == null || this.tarjeta == null) {
            JOptionPane.showMessageDialog(null, "La cuenta o Tarjeta solicitada no existe.");
            return;
        } else if (!this.cuenta.getTipoCuenta().equals(this.tarjeta.getTipo())) {
            JOptionPane.showMessageDialog(null, "Tipo de cuenta y tarjeta no compatibles.");
            return;
        }
        asociarCuentaATarjeta();
        JOptionPane.showMessageDialog(null, "Tarjeta y cuenta asociadas con éxito.");
    }

    private Cuenta capturarCuenta(String numeroDeCuenta) {
        return CuentasDAOtxt.getInstance().buscarCuenta(numeroDeCuenta);
    }

    private Tarjeta capturarTarjeta(String panTarjeta) {
        return TarjetasDAOtxt.getInstance().buscarTarjeta(panTarjeta);
    }

    private void asociarCuentaATarjeta() {
        this.tarjeta.setNumeroCuenta(this.cuenta.getNumeroDeCuenta());
        TarjetasDAOtxt.getInstance().actualizarTarjeta(this.tarjeta);
    }


}
