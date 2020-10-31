package tpComercio;
import tpComercio.Actor;
import tpComercio.Contacto;

	public class Cliente extends Actor{
	    private String apellido;
	    private String nombre;
	    private long dni;

		public Cliente(int id, Contacto contacto, String apellido, String nombre, long dni) {
			super(id, contacto);
			this.apellido = apellido;
			this.nombre = nombre;
			this.dni = dni;
		}

		public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public long getDni() {
	        return dni;
	    }

	    public void setDni(long dni) {
	        this.dni = dni;
	    }
	  
	//Metodo para validar dni
	boolean validarIdentificadorUnico(long dni) {
		String dniFinal = Long.toString(dni);
		try {
	        Integer i = Integer.parseInt(dniFinal);
	    } catch (NumberFormatException nfe) {
	    	System.out.println("El dni es erroneo porque contiene letras");
	        return false;
	    }
		System.out.println("El dni no contiene letras");
		return true;
		}
	}

