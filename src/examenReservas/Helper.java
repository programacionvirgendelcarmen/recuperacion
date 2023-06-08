package examenReservas;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<Reserva> leerReservas(String ruta) throws IOException, InstanciaMinimaExcepcion {
        List<Reserva> reservas = new ArrayList<>();
        Path path = Path.of(ruta);
        List<String> lineas = Files.readAllLines(path);
        /*APARTA HOTEL,R02,2,MEDIA,3,2,FALSE
        CASA RURAL,R03,2,NINGUNA,4,2,TRUE
        HOTEL,R05,2,COMPLETA,4,4,TRUE
         */
        for( String linea : lineas) {
            String[] tokens = linea.split(",");
            String reserva = tokens[0];
            String nombreReserva = tokens[1];
            String sNumeroNoches = tokens[2];
            int numeroNoches = Integer.parseInt(sNumeroNoches);
            String sTipoReserva = tokens[3];
            TipoReserva tipoReserva = crearTipoReserva(sTipoReserva);
            String sNumeroPersonas = tokens[4];
            int numeroPersonas = Integer.parseInt(sNumeroPersonas);
            switch (reserva) {
                case "APARTA HOTEL":
                    String sNumeroHabitaciones1 = tokens[5];
                    int numeroHabitaciones1 = Integer.parseInt(sNumeroHabitaciones1);
                    String sLimpieza = tokens[6].toLowerCase();
                    boolean limpieza = Boolean.parseBoolean(sLimpieza);
                    reservas.add(new ApartaHotel(reserva, numeroNoches, tipoReserva,
                            numeroPersonas, numeroHabitaciones1, limpieza));
                    break;
                case "CASA RURAL":
                    String sNumeroHabitaciones2 = tokens[5];
                    int numeroHabitaciones2 = Integer.parseInt(sNumeroHabitaciones2);
                    String sPiscina = tokens[6].toLowerCase();
                    boolean piscina = Boolean.parseBoolean(sPiscina);
                    reservas.add(new CasaRural(reserva, numeroNoches, tipoReserva,
                            numeroPersonas, numeroHabitaciones2, piscina));
                    break;
                case "HOTEL":
                    String sEstrellas = tokens[5];
                    int estrellas = Integer.parseInt(sEstrellas);
                    String sDoble = tokens[6].toLowerCase();
                    boolean doble = Boolean.parseBoolean(sDoble);
                    reservas.add(new Hotel(reserva, numeroNoches, tipoReserva,
                            numeroPersonas, doble, estrellas));
                    break;
                default:
                    break;
            }
        }
        return reservas;
    }

    private static TipoReserva crearTipoReserva(String sTipoReserva) {
        switch (sTipoReserva) {
            case "COMPLETA" :
                return TipoReserva.COMPLETA;
            case "MEDIA" :
                return TipoReserva.MEDIA;
            case "NINGUNA" :
                return TipoReserva.NINGUNA;
            default:
                return null;
        }
    }
    public static void escribirReservas(String ruta, List<Reserva> reservas) throws IOException {
        Path path = Paths.get(ruta);
        StringBuilder builder = new StringBuilder();
        for (Reserva reserva : reservas) {
            builder.append(reserva.toString()).append('\n');
        }
        Files.writeString(path, builder.toString(), StandardOpenOption.CREATE);
    }

    public static void main(String[] args) {
        List<Reserva> lista = null;
        try {
            lista = leerReservas("FILES/reservas.csv");
            lista.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InstanciaMinimaExcepcion e) {
            throw new RuntimeException(e);
        }
        try {
            escribirReservas("FILES/backup.csv", lista);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
