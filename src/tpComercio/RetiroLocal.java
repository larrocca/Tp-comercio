package tpComercio;
import java.time.*;
import java.time.format.*;

public class RetiroLocal extends Entrega{
    private LocalTime horaEntrega;

    public RetiroLocal(int id, LocalDate fecha) {
        super(id, fecha);
        this.horaEntrega= null;
    }
  
    public LocalTime getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(LocalTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }
    
}