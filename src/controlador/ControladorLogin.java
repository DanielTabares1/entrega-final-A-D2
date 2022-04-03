package controlador;

import DAO.UsuariosDAOtxt;
import modelo.AuxiliarBancario;

import javax.swing.*;

public class ControladorLogin {

    private static String userName;
    private static String password;

    public static AuxiliarBancario logIn() {
        AuxiliarBancario auxiliarBancario;
        do {
            userName = JOptionPane.showInputDialog("Digite su nombre de usuario.");
            password = JOptionPane.showInputDialog("Digite su contraseña.");
            auxiliarBancario = UsuariosDAOtxt.getInstance().buscarUsuario(userName, password);

            if (auxiliarBancario == null) {
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
            }
        } while (auxiliarBancario == null);

        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso\nBienvenido, " + auxiliarBancario.getUserName());
        return auxiliarBancario;
    }


}
