package DAO;

import com.google.gson.Gson;
import modelo.AuxiliarBancario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsuariosDAOtxt implements UsuariosDAO {

    private static UsuariosDAOtxt instance;
    private static Gson gson = new Gson();

    private UsuariosDAOtxt() {
    }

    public static UsuariosDAOtxt getInstance() {
        if (instance == null) {
            instance = new UsuariosDAOtxt();
        }
        return instance;
    }

    @Override
    public AuxiliarBancario buscarUsuario(String userName, String password) {
        try {
            FileReader reader = new FileReader("src/recursos/UsuariosJson.txt");
            BufferedReader reader1 = new BufferedReader(reader);
            String usuarioJson = reader1.readLine();
            while (usuarioJson != null) {
                AuxiliarBancario auxiliarBancario = gson.fromJson(usuarioJson, AuxiliarBancario.class);
                if (auxiliarBancario.getUserName().equals(userName) && auxiliarBancario.getPassword().equals(password)) {
                    return auxiliarBancario;
                }
                usuarioJson = reader1.readLine();
            }
        } catch (IOException e) {
            System.err.println("Archivo no encontrado");
        }
        return null;
    }
}
