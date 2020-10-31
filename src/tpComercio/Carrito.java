package tpComercio;
import java.time.*;
import tpComercio.Entrega;
import java.time.format.*;
import java.util.List;
import tpComercio.Entrega;
import tpComercio.Cliente;
import tpComercio.ItemCarrito;
import tpComercio.Turno;


public class Carrito {
    private int id;
    private LocalDate fecha;
    private boolean cerrado;
    private double descuento;
    private Cliente cliente;
    private List<ItemCarrito>lstItemCarrito;
    private LocalTime hora;
    private Entrega entrega;
    

    public Carrito(int id, boolean cerrado, double descuento, Cliente cliente, List<ItemCarrito> lstItemCarrito) {
        this.id = id;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.cerrado = cerrado;
        this.descuento = descuento;
        this.cliente = cliente;
        this.lstItemCarrito = lstItemCarrito;
    }
    
    
    public Entrega getEntrega() {
		return entrega;
	}


	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemCarrito> getLstItemCarrito() {
        return lstItemCarrito;
    }

    public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
        this.lstItemCarrito = lstItemCarrito;
    }
    
    boolean agregar(Articulo articulo , int cantidad){
		boolean determinador=true;
		for(ItemCarrito i: lstItemCarrito) {
			if(i.getArticulo().getId() == articulo.getId()) {
				i.setCantidad(i.getCantidad()+cantidad);
			}
			else
			{
				this.lstItemCarrito.add(new ItemCarrito(articulo,cantidad));
			}
		}
		return determinador;
		}
    
    public void traerHoraRetiro(LocalDate fecha) {
    	
    }
}
