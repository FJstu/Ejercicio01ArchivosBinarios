package ejercicio01ArchivosBinarios.modelo.procesos;

import ejercicio01ArchivosBinarios.modelo.beans.Sensor;

import java.util.HashMap;

public class GestionSensores {

    public void mostrarSensores(HashMap<Integer, Sensor> sensores) {
        System.out.println("SENSORES: ");
        for (Sensor sensor : sensores.values()) {
            System.out.println(sensor);
        }
    }
}
