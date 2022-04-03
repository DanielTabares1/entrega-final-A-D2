package DAO;

import com.google.gson.Gson;
import modelo.AuxiliarBancario;
import modelo.Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClientesDAOtxt implements ClientesDAO {

    private static ClientesDAOtxt instance;
    private static Gson gson = new Gson();

    private ClientesDAOtxt() {
    }

    public static ClientesDAOtxt getInstance() {
        if (instance == null) {
            instance = new ClientesDAOtxt();
        }
        return instance;
    }


    @Override
    public Cliente buscarCliente(String idCliente) {

        try {
            FileReader reader = new FileReader("src/recursos/ClientesJson.txt");
            BufferedReader reader1 = new BufferedReader(reader);
            String clienteJson = reader1.readLine();
            while (clienteJson != null) {
                Cliente cliente = gson.fromJson(clienteJson, Cliente.class);
                if (cliente.getId().equals(idCliente)) {
                    return cliente;
                }
                clienteJson = reader1.readLine();
            }
        } catch (IOException e) {
            System.err.println("Archivo no encontrado");
        }
        return null;

    }
}
