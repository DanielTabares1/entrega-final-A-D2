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
    }

    private Cliente capturarCliente(String idCliente) {
        Cliente cliente = ClientesDAOtxt.getInstance().buscarCliente(idCliente);
        if(verificarAptitud(cliente)) return cliente;
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

    public boolean verificarAptitud(Cliente cliente){
        //todo.... aplicar lógica de negocio para verificar que el cliente es apto
        return true;
    }



}
