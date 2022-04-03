import controlador.ControladorLogin;
import modelo.AuxiliarBancario;
import modelo.Tarjeta;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        AuxiliarBancario auxiliarBancario = ControladorLogin.logIn();

        int opcion = 0;
        String mensajeOpciones = """
                Digite la opción que prefiera entre las siguientes:
                1. Registrar una nueva tarjeta
                2. Asociar una cuenta a una tarjeta
                3. Salir
                """;

        while (opcion != 3) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(mensajeOpciones));
            switch (opcion) {
                case 1 -> {Tarjeta tarjeta = auxiliarBancario.crearTarjeta();}
                case 2 -> auxiliarBancario.asociarcuentaATarjeta();
                case 3 -> JOptionPane.showMessageDialog(null, "Saliendo...\nTenga un buen día");
                default -> System.out.println("La opción ingresada no es válida");
            }
        }



    }
}
