package RA5;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    private static List<CuentaPersonal> cuentaPersonals = null;
    public static void main(String[] args) {

            mostrarMenu();


    }

    private static void hacerCopiaSeguridad() {
        System.out.println("Introduce la ruta del fichero a copiar");
        String rutaEntrada = scanner.nextLine();
        System.out.println("Introduce en el nombre de la copia");
        String rutaCopia = scanner.nextLine();
        try {
            Helper.crearCopiaSeguridad(rutaEntrada, rutaCopia);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirFichero() {
        System.out.println("Introduce la ruta del fichero a escribir");
        String ruta = scanner.nextLine();
        if (cuentaPersonals == null){
            System.out.println("No hay cuentas");
            return;
        }
        try {
            Helper.guardarCuentas(ruta, cuentaPersonals);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerFichero() {
        System.out.println("Introduce la ruta del fichero a leer");
        String ruta = scanner.nextLine();
        try {
            cuentaPersonals = Helper.generarCuentas(ruta);
            System.out.printf("Creadas %d cuentas%n", cuentaPersonals.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void mostrarMenu () {
        int opcion = -1;
        do {
          System.out.println("0. Salir");
           System.out.println("1. Leer Fichero");
           System.out.println("2. Escribir Fichero");
           System.out.println("3. Hacer copia de seguridad");

           switch (opcion){
                case 0:
                    System.out.println("Fin de programa");
                    scanner.close();
                     return;
                case 1:
                    leerFichero();
                    break;
                case 2:
                    escribirFichero();
                    break;
                case 3:
                    hacerCopiaSeguridad();
                    break;
                default:
                    break;
        }
        } while (opcion < 0 || opcion > 3) ;

    }
}
