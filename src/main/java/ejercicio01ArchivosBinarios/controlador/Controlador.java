package ejercicio01ArchivosBinarios.controlador;

import ejercicio01ArchivosBinarios.modelo.beans.Sensor;
import ejercicio01ArchivosBinarios.modelo.procesos.GestionArchivos;
import ejercicio01ArchivosBinarios.modelo.procesos.GestionSensores;

import java.util.HashMap;

public class Controlador {
    public void ejecutar() {
        GestionArchivos gestionArchivos = new GestionArchivos();
        GestionSensores gestionSensores = new GestionSensores();

        HashMap<Integer, Sensor> sensores = gestionArchivos.leerArchivoSensores();
        gestionArchivos.escribirArchivoCopiaSensores(sensores);
        System.out.println("Copia de archivo en texto plano guardada correctamente.");

        HashMap<Integer, Sensor> sensoresBin = gestionArchivos.leerArchivoCopiaSensores();
        gestionArchivos.escribirArchivoSensoresBin(sensoresBin);
        System.out.println("Archivo binario guardado correctamente.");

        gestionSensores.mostrarSensores(sensoresBin);
    }
}
