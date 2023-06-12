package RA5;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<CuentaPersonal> generarCuentas(String rutaFichero) throws IOException {
        List<CuentaPersonal> cuentas = new ArrayList<>();
        Path path = Paths.get(rutaFichero);
        List<String> lineas = Files.readAllLines(path);
        //hay que saltarse la primera línea porque es la cabecera
        for (int i = 1; i < lineas.size() ; i++) {
            //4175009004250066,CY06 4584 7189 MUJR SOVO NYCY 1NMU,Pula,3.36
            String[] tokens =  lineas.get(i).split(",");
            String numeroTarjeta = tokens[0];
            String numeroCuenta  = tokens[1];
            String moneda        = tokens[2];
            String sSaldo        = tokens[3];
            double saldo         = Double.parseDouble(sSaldo);
            CuentaPersonal cuenta = new CuentaPersonal(
                    numeroTarjeta, numeroCuenta, moneda, saldo);
            cuentas.add(cuenta);
        }
        return cuentas;
    }
    public static void guardarCuentas(String rutaFichero, List<CuentaPersonal> cuentas) throws IOException {
        //cuantas_18_27_33__8_9_2023.csv
        StringBuilder builderRuta = new StringBuilder(rutaFichero);
        builderRuta.append('/').append("cuentas_");
        LocalDateTime fecha = LocalDateTime.now();
        builderRuta.append(fecha.getHour()).append('_');
        builderRuta.append(fecha.getMinute()).append('_');
        builderRuta.append(fecha.getSecond()).append("__");
        builderRuta.append(fecha.getDayOfMonth()).append('_');
        builderRuta.append(fecha.getMonthValue()).append('_');
        builderRuta.append(fecha.getYear()).append(".csv");
        Path path = Paths.get(builderRuta.toString());
        StringBuilder builder = new StringBuilder("numeroTarjeta,numeroCuenta,moneda,saldo")
                .append('\n');
        for (CuentaPersonal cuenta : cuentas){
            builder.append(cuenta.toString()).append('\n');
        }
        Files.writeString(path, builder.toString());
    }
    public static void crearCopiaSeguridad(String rutaFicheroEntrada,
                                           String rutaFicheroSalida) throws IOException {
        StringBuilder builder = new StringBuilder(
                rutaFicheroEntrada.replace(".csv", ""));
        builder.append('_').append(rutaFicheroSalida).append(".csv");
        Path pathOrigen = Paths.get(rutaFicheroEntrada);
        Path pathSalida = Paths.get(builder.toString());
        Files.copy(pathOrigen, pathSalida, StandardCopyOption.REPLACE_EXISTING);
    }
    /*public static void main(String[] args) {
        try {
         //   System.out.println(generarCuentas("FILES/datos.csv"));
         //guardarCuentas("FILES", generarCuentas("FILES/datos.csv"));
            crearCopiaSeguridad("FILES/cuentas_15_42_56__12_6_2023.csv",
                   "backup" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
