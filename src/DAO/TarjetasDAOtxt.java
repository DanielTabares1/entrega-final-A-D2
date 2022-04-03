package DAO;

import com.google.gson.Gson;
import modelo.AuxiliarBancario;
import modelo.Tarjeta;

import java.io.*;
import java.util.ArrayList;

public class TarjetasDAOtxt implements TarjetasDAO {

    private static TarjetasDAOtxt instance;
    private static Gson gson = new Gson();

    private TarjetasDAOtxt() {
    }

    public static TarjetasDAOtxt getInstance() {
        if (instance == null) {
            instance = new TarjetasDAOtxt();
        }
        return instance;
    }

    @Override
    public void registrarTarjeta(Tarjeta tarjeta) {
        try {
            FileWriter writer = new FileWriter("src/recursos/TarjetasJson.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(getInstance().gson.toJson(tarjeta));
            printWriter.flush();
        } catch (IOException e) {
            System.err.println("Archivo no encontrado");
        }
    }

    @Override
    public Tarjeta buscarTarjeta(String panTarjeta) {
        try {
            FileReader reader = new FileReader("src/recursos/TarjetasJson.txt");
            BufferedReader reader1 = new BufferedReader(reader);
            String tarjetaJson = reader1.readLine();
            while (tarjetaJson != null) {
                Tarjeta tarjeta = gson.fromJson(tarjetaJson, Tarjeta.class);
                if (tarjeta.getPan().equals(panTarjeta)) {
                    return tarjeta;
                }
                tarjetaJson = reader1.readLine();
            }
        } catch (IOException e) {
            System.err.println("Archivo no encontrado");
        }
        return null;
    }

    @Override
    public void actualizarTarjeta(Tarjeta tarjeta) {
        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        try {
            FileReader reader = new FileReader("src/recursos/TarjetasJson.txt");
            BufferedReader reader1 = new BufferedReader(reader);
            String tarjetaJson = reader1.readLine();
            while (tarjetaJson != null) {
                Tarjeta tarjeta1 = gson.fromJson(tarjetaJson, Tarjeta.class);
                if (tarjeta1.getPan().equals(tarjeta.getPan())) {
                    tarjeta1.setNumeroCuenta(tarjeta.getNumeroCuenta());
                }
                tarjetas.add(tarjeta1);
                tarjetaJson = reader1.readLine();
                System.out.println("Añadimos tarjeta");
            }
            reader.close();

            FileWriter writer = new FileWriter("src/recursos/TarjetasJson.txt", false);
            writer.write("");
            writer = new FileWriter("src/recursos/TarjetasJson.txt", true);
            BufferedWriter writer1 = new BufferedWriter(writer);
            PrintWriter writer2 = new PrintWriter(writer1);
            for (Tarjeta t : tarjetas) {
                writer2.println(gson.toJson(t));
                System.out.println("re escribimos tarjeta");
            }
            writer2.flush();
        } catch (IOException e) {
            System.err.println("Archivo no encontrado");
        }
    }
}
