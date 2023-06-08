package examen3;

import java.util.Objects;

public class Obrero implements Trabajador{
    public final double HORA_TRABAJADA = 65.5;
    public String identificacion;
    public Departamento departamento;
    public int horasMensualesTrabajadas;

    public Obrero(String identificacion, Departamento departamento,
                  int horasMensualesTrabajadas) {
        this.identificacion = identificacion;
        this.departamento = departamento;
        this.horasMensualesTrabajadas = horasMensualesTrabajadas;
    }

    @Override
    public double obtenerSueldoMensual() {
        return SUELDO_BASE_MENSUAL + horasMensualesTrabajadas * HORA_TRABAJADA;
    }

    @Override
    public String obtenerIdentificacion() {
        return String.format("%s,%s,%d", identificacion,
                departamento, horasMensualesTrabajadas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obrero obrero = (Obrero) o;
        return Objects.equals(identificacion, obrero.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion);
    }
}
