package examenReservas;

public class Hotel extends Reserva{
    private boolean habitacionDoble;
    private int numeroEstrellas;

    public Hotel(String nombreReserva, int numeroNoches, TipoReserva tipoReserva, int numeroPersona,
                 boolean habitacionDoble, int numeroEstrellas) throws InstanciaMinimaExcepcion {
        super(nombreReserva, numeroNoches, tipoReserva, numeroPersona);
        this.habitacionDoble = habitacionDoble;
        this.numeroEstrellas = numeroEstrellas;
    }

    public boolean isHabitacionDoble() {
        return habitacionDoble;
    }

    public void setHabitacionDoble(boolean habitacionDoble) {
        this.habitacionDoble = habitacionDoble;
    }

    public int getNumeroEstrellas() {
        return numeroEstrellas;
    }

    public void setNumeroEstrellas(int numeroEstrellas) {
        this.numeroEstrellas = numeroEstrellas;
    }
    @Override
    public String toString() {
        return String.format("HOTEL,%s,%d,%B", super.toString(),
                numeroEstrellas, habitacionDoble);
    }
}
