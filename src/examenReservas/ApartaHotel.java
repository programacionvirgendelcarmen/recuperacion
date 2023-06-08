package examenReservas;

public class ApartaHotel extends Reserva{
    private int numeroHabitaciones;
    private boolean limpieza;

    public ApartaHotel(String nombreReserva, int numeroNoches, TipoReserva tipoReserva, int numeroPersona,
                       int numeroHabitaciones, boolean limpieza) throws InstanciaMinimaExcepcion {
        super(nombreReserva, numeroNoches, tipoReserva, numeroPersona);
        this.numeroHabitaciones = numeroHabitaciones;
        this.limpieza = limpieza;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }



    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public boolean isLimpieza() {
        return limpieza;
    }

    public void setLimpieza(boolean limpieza) {
        this.limpieza = limpieza;
    }
    @Override
    public String toString() {
        return String.format("APARTA HOTEL,%s,%d,%B", super.toString(),
                numeroHabitaciones, limpieza);
    }
}
