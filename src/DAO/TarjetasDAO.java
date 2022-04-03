package DAO;

import modelo.Tarjeta;

public interface TarjetasDAO {

    void registrarTarjeta(Tarjeta tarjeta);

    Tarjeta buscarTarjeta(String panTarjeta);

    void actualizarTarjeta(Tarjeta tarjeta);

}
