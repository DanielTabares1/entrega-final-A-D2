package DAO;

import com.google.gson.Gson;
import modelo.AuxiliarBancario;
import modelo.Cuenta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CuentasDAOtxt implements CuentasDAO {

    private static CuentasDAOtxt instance;
    private static Gson gson = new Gson();

    private CuentasDAOtxt() {
    }

    public static CuentasDAOtxt getInstance() {
        if (instance == null) {
            instance = new CuentasDAOtxt();
        }
        return instance;
    }


    @Override
    public Cuenta buscarCuenta(String numeroCuenta) {
        try {
            FileReader reader = new FileReader("src/recursos/CuentasJson.txt");
            BufferedReader reader1 = new BufferedReader(reader);
            String cuentaJson = reader1.readLine();
            while (cuentaJson != null) {
                Cuenta cuenta = gson.fromJson(cuentaJson, Cuenta.class);
                if (cuenta.getNumeroDeCuenta().equals(numeroCuenta)) {
                    return cuenta;
                }
                cuentaJson = reader1.readLine();
            }
        } catch (IOException e) {
            System.err.println("Archivo no encontrado");
        }
        return null;
    }
}
