package controlador;

import DAO.ClientesDAOtxt;
import DAO.TarjetasDAOtxt;
import modelo.Cliente;
import modelo.Tarjeta;

import javax.swing.*;
import java.sql.ClientInfoStatus;

public class ControladorCrearTarjeta {
    private String tipoTarjeta;
    private Cliente cliente;

    public ControladorCrearTarjeta() {
        this.tipoTarjeta = JOptionPane.showInputDialog("Digite el tipo de Tarjeta a registrar");
        String idCliente = JOptionPane.showInputDialog("Digite el documento de identidad del cliente");
        this.cliente = capturarCliente(idCliente);
        if (this.cliente == null) {
            JOptionPane.showMessageDialog(null, "El cliente no es apto para crear una tarjeta\n" +
                    "motivo: Ingresos insuficientes, debe ganar más de $50.000/mes\n" +
                    "Proceso cancelado.");
        }
    }

    private Cliente capturarCliente(String idCliente) {
        Cliente cliente = ClientesDAOtxt.getInstance().buscarCliente(idCliente);
        if (verificarAptitud(cliente)) return cliente;
        return null;
    }

    public Tarjeta registrarTarjeta() {
        String pin = JOptionPane.showInputDialog("Digite su pin");
        String tipo = this.tipoTarjeta;
        String marca = JOptionPane.showInputDialog("Digite la marca de la tarjeta");
        Tarjeta tarjeta = new Tarjeta(cliente, pin, tipo, marca);
        TarjetasDAOtxt.getInstance().registrarTarjeta(tarjeta);
        return tarjeta;
    }

    public boolean verificarAptitud(Cliente cliente) {
        return (cliente.getIngresosMensuales() >= 50000);
    }

    public boolean apto() {
        return cliente != null;
    }

}
