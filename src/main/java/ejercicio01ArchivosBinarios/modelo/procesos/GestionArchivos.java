package ejercicio01ArchivosBinarios.modelo.procesos;

import ejercicio01ArchivosBinarios.modelo.beans.Sensor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GestionArchivos {

    public HashMap<Integer, Sensor> leerArchivoSensores() {
        String linea;
        HashMap<Integer, Sensor> sensores = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("sensores.txt"))) {
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                ArrayList<Double> datos = new ArrayList<>();
                for (int i = 1; i < partes.length; i++) {
                    datos.add(Double.parseDouble(partes[i]));
                }
                if (partes.length > 0) {
                    Sensor sensor = new Sensor(Integer.parseInt(partes[0]), partes.length-1, datos);
                    sensores.put(sensor.getIdSensor(), sensor);
                }
            }
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }

        return sensores;
    }

    public void escribirArchivoCopiaSensores(HashMap<Integer, Sensor> sensores) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("copiaSensores.txt"))) {
            for (Sensor sensor : sensores.values()) {
                pw.println(sensor);
            }
        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        }
    }

    public HashMap<Integer, Sensor> leerArchivoCopiaSensores() {
        String linea;
        HashMap<Integer, Sensor> sensores = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("copiaSensores.txt"))) {
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                ArrayList<Double> datos = new ArrayList<>();
                for (int i = 1; i < partes.length; i++) {
                    datos.add(Double.parseDouble(partes[i]));
                }
                if (partes.length > 0) {
                    Sensor sensor = new Sensor(Integer.parseInt(partes[0]), partes.length-1, datos);
                    sensores.put(sensor.getIdSensor(), sensor);
                }
            }
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }

        return sensores;
    }

    public void escribirArchivoSensoresBin(HashMap<Integer, Sensor> sensores) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("sensoresBin"))) {
            for (Sensor sensor : sensores.values()) {
                dos.writeInt(sensor.getIdSensor());
                dos.writeInt(sensor.getNumDatos());

                for (Double dato : sensor.getDatos()) {
                    dos.writeDouble(dato);
                }
            }
        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        }
    }
}
