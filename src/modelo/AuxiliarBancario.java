package modelo;

import DAO.TarjetasDAOtxt;
import controlador.ControladorAsociarCuentaATarjeta;
import controlador.ControladorCrearTarjeta;

public class AuxiliarBancario extends Persona {

    private String userName;
    private String password;

    public AuxiliarBancario(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Tarjeta crearTarjeta() {
        ControladorCrearTarjeta crearTarjeta = new ControladorCrearTarjeta();
        if(crearTarjeta.apto()){
            Tarjeta tarjeta = crearTarjeta.registrarTarjeta();
            return tarjeta;
        }
        return null;
    }

    public void asociarcuentaATarjeta() {
        ControladorAsociarCuentaATarjeta asociarCuentaATarjeta = new ControladorAsociarCuentaATarjeta();
    }


}
