package examenReservas;

import java.time.LocalDate;

public class Reserva {
    private String nombreReserva;
    private int numeroNoches;
    private LocalDate fechaReserva = LocalDate.now();
    private TipoReserva tipoReserva;
    private int numeroPersonas;
    public Reserva(String nombreReserva, int numeroNoches,
                   TipoReserva tipoReserva, int numeroPersona) throws InstanciaMinimaExcepcion {
        if (numeroNoches < 2)
            throw new InstanciaMinimaExcepcion("mínimo dos noches");

        this.nombreReserva = nombreReserva;
        this.numeroNoches = numeroNoches;
        this.tipoReserva = tipoReserva;
        this.numeroPersonas = numeroPersona;
    }

    public String getNombreReserva() {
        return nombreReserva;
    }

    public void setNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
    }

    public int getNumeroNoches() {
        return numeroNoches;
    }

    public void setNumeroNoches(int numeroNoches) throws InstanciaMinimaExcepcion {
        if (numeroNoches > 1)
            this.numeroNoches = numeroNoches;
        else
            throw new InstanciaMinimaExcepcion("Mínimo dos noches");
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    @Override
    public String toString() {
        return String.format("%s,%d,%d/%d/%d,%s,%d", nombreReserva, numeroNoches,
                fechaReserva.getDayOfMonth(), fechaReserva.getMonthValue(),
                fechaReserva.getYear(), tipoReserva, numeroPersonas);
    }
}
