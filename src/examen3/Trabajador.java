package examen3;

import java.util.List;

public interface Trabajador {
    double SUELDO_BASE_MENSUAL = 1000;
    double obtenerSueldoMensual();
    String obtenerIdentificacion();

    default String generarInformacionCompleta() {
        return String.format("%s,%.2f", obtenerIdentificacion(),
                obtenerSueldoMensual());
    }
    static Trabajador obtenerTrabajadorMayorSueldo(List<Trabajador> trabajadores){
        Trabajador trabajadorMayorSueldo = null;
        double sueldoMayor = 0;
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.obtenerSueldoMensual() > sueldoMayor){
                sueldoMayor = trabajador.obtenerSueldoMensual();
                trabajadorMayorSueldo = trabajador;
            }
        }
        return  trabajadorMayorSueldo;
    }

}
