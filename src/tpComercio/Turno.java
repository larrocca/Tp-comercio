package tpComercio;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
import java.util.List;

public class Turno {
    private LocalDate dia;
    private LocalTime hora;
    private boolean ocupado;

    public Turno(LocalDate dia, LocalTime hora) {
        this.dia = dia;
        this.hora = hora;
        this.ocupado = false;
    }
    
    public void generarAgenda(LocalDate fecha) {
 
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
