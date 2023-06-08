package examenReservas;

public class CasaRural extends Reserva{
    private int numeroHabitaciones;
    private boolean piscina;

    public CasaRural(String nombreReserva, int numeroNoches, TipoReserva tipoReserva, int numeroPersona,
                     int numeroHabitaciones, boolean piscina) throws InstanciaMinimaExcepcion {
        super(nombreReserva, numeroNoches, tipoReserva, numeroPersona);
        this.numeroHabitaciones = numeroHabitaciones;
        this.piscina = piscina;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }
    @Override
    public String toString() {
        return String.format("CASA RURAL,%s,%d,%B", super.toString(),
                numeroHabitaciones, piscina);
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }
}
