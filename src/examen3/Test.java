package examen3;

public class Test {
    public static void main(String[] args) {
        Trabajador obrero1 = new Obrero(
                "E000", Departamento.FABRICA, 20);
        Trabajador obrero2 = new Obrero(
                "E001", Departamento.ADMINISTRACION, 2);
        Trabajador tecnico1 = new Tecnico(
                "T00", Departamento.FABRICA, 11);
        Trabajador tecnico2 =  new Tecnico(
                "T01", Departamento.ALMACEN, 10);
        Empresa empresa = new Empresa("Empresa nueva");
        empresa.contratarTrabajador(obrero1);
        empresa.contratarTrabajador(obrero2);
        empresa.contratarTrabajador(tecnico1);
        empresa.contratarTrabajador(tecnico2);
        for (Trabajador trabajador: empresa.getTrabajadores()) {
            System.out.println(trabajador.generarInformacionCompleta());
        }
        empresa.darDeBajaTrabajador(obrero1);
        empresa.darDeBajaTrabajador(tecnico1);
        System.out.println("------------------------------");
        for (Trabajador trabajador: empresa.getTrabajadores()) {
            System.out.println(trabajador.generarInformacionCompleta());
        }
        System.out.println("------Trabajador mayor sueldo---------");
        System.out.println(
                Trabajador.obtenerTrabajadorMayorSueldo(
                        empresa.getTrabajadores()).generarInformacionCompleta()
        );

    }
}
