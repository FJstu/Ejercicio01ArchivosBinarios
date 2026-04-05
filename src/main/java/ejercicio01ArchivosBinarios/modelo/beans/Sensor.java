package ejercicio01ArchivosBinarios.modelo.beans;

import java.util.ArrayList;

public class Sensor {
    private Integer idSensor;
    private Integer numDatos;
    private ArrayList<Double> datos;

    public Sensor(Integer idSensor, Integer numDatos, ArrayList<Double> datos) {
        this.idSensor = idSensor;
        this.numDatos = numDatos;
        this.datos = datos;
    }

    public Integer getIdSensor() {
        return idSensor;
    }

    public Integer getNumDatos() {
        return numDatos;
    }

    public ArrayList<Double> getDatos() {
        return datos;
    }

    @Override
    public int hashCode() {
        return this.idSensor.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sensor sensor = (Sensor) obj;

        return this.idSensor.equals(sensor.getIdSensor());
    }

    @Override
    public String toString() {
        StringBuilder linea = new StringBuilder();
        linea.append(this.idSensor);
        for (Double dato : this.datos) {
            linea.append(":").append(dato);
        }
        return linea.toString();
    }
}
