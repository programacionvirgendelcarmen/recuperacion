package examen3;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombreEmpresa;
   // private List<Trabajador> trabajadores = new ArrayList<>();
   private List<Trabajador> trabajadores;
    public Empresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.trabajadores = new ArrayList<>();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public boolean contratarTrabajador(Trabajador trabajador) {
        return trabajadores.add(trabajador);
    }
    public boolean darDeBajaTrabajador(Trabajador trabajador) {
        return trabajadores.remove(trabajador);
    }
}
