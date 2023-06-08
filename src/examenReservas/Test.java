package examenReservas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static examenReservas.Helper.leerReservas;

/*
Crear seis tipo de reservas, dos hotel, dos aparta hotel
y dos casa rural
Guardamons en una lista de reservas
luego mostramos la información de ellas
 */

public class Test {
    public static void main(String[] args) {
        List<Reserva> reservas1 = new ArrayList<>();
        List<Reserva> reservas2 = null;
        Reserva ah1 = null, ah2 = null, ho1 = null, ho2 = null, cr1 = null, cr2 = null;
        try {
            ah1 = new ApartaHotel("R01",1, TipoReserva.COMPLETA,
                    3,2,true);
            reservas1.add(ah1);
        } catch (InstanciaMinimaExcepcion e) {
            System.err.println(e.getMessage());
        }
        try {    ah2 = new ApartaHotel("R02",2, TipoReserva.MEDIA,
                3,2,false);
            reservas1.add(ah2);
        } catch (InstanciaMinimaExcepcion e) {
            System.err.println(e.getMessage());
        }
        try {    cr1 = new CasaRural("R03", 2, TipoReserva.NINGUNA,
                4, 2,true);
            reservas1.add(cr1);
        } catch (InstanciaMinimaExcepcion e) {
            System.err.println(e.getMessage());
        }
        try {    cr2 = new CasaRural("R04", 4, TipoReserva.NINGUNA,
                4, 2,false);
            reservas1.add(cr2);
        } catch (InstanciaMinimaExcepcion e) {
            System.err.println(e.getMessage());
        }
        try {    ho1 = new Hotel("R05", 2, TipoReserva.COMPLETA,
                4, true, 4);
            reservas1.add(ho1);
        } catch (InstanciaMinimaExcepcion e) {
            System.err.println(e.getMessage());
        }
        try {    ho2 = new Hotel("R06", 1, TipoReserva.COMPLETA,
                4, false, 4);
            reservas1.add(ho2);
        } catch (InstanciaMinimaExcepcion e) {
            System.err.println(e.getMessage());
        }
        try {
            reservas2 = leerReservas("FILES/reservas.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InstanciaMinimaExcepcion e) {
            throw new RuntimeException(e);
        }

        mostrarInformacionReservas(reservas1);
        System.out.println("__________________________________________");
        mostrarInformacionReservas(reservas1);



    }

    private static void mostrarInformacionReservas(List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
}
