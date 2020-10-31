package tpComercio;

import tpComercio.DiaRetiro;
import tpComercio.Carrito;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.time.format.*;
import java.time.*;
import tpComercio.Turno;
import tpComercio.Test;
import tpComercio.DiaRetiro;
import tpComercio.RetiroLocal;

public class Comercio extends Actor {
	private String nombreComercio;
	private Long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private List<DiaRetiro> lstDiaRetiro;
	private List<Carrito> lstCarrito;

	public Comercio(int id, Contacto contacto) {
		super(id, contacto);
	}

	public Comercio(String nombreComercio, Long cuit, double costoFijo, double costoPorKm, int diaDescuento,
			int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo, int id, Contacto contacto) {
		super(id, contacto);
		this.nombreComercio = nombreComercio;
		this.cuit = cuit;
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}

	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	public double getCostoPorKm() {
		return costoPorKm;
	}

	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}

	public int getDiaDescuento() {
		return diaDescuento;
	}

	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}

	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}

	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}

	public int getPorcentajeDescuentoEfectivo() {
		return porcentajeDescuentoEfectivo;
	}

	public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}

	public List<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}

	public void setLstDiaRetiro(List<DiaRetiro> lstDiaRetiro) {
		this.lstDiaRetiro = lstDiaRetiro;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	public void generarTurnosLibres(LocalDate fecha){
		LocalDate dia = fecha;
		LocalTime hora = LocalTime.of(8, 00);
		Turno turno1 = new Turno(dia, hora);
		Test.lstTurnos.add(turno1);
		for (int i = 1; i < 9; i++) {
			Turno turno = new Turno(dia, hora);
			turno.setDia(fecha);
			turno.setHora(hora.plusMinutes(10 * i));
			Test.lstTurnos.add(turno);
			System.out.println("Turno numero:" + i + " " + " " + turno.getDia() + " " + " " + turno.getHora() + " "
					+ turno.isOcupado());
		}
	}

	public void generarTurnosOcupados(LocalDate fecha) {
		int totalCarritos = 0;
		for (int h = 0; h < this.lstCarrito.size(); h++) {
			if (this.lstCarrito.get(h).getFecha() == fecha) {
				if (this.lstCarrito.get(h).getEntrega() instanceof RetiroLocal) {
					System.out.println("la fecha del carrito es:" + " " + this.lstCarrito.get(h).getFecha());
					totalCarritos = totalCarritos + 1;
				}
			}
		}
		for (int i = 0; i < totalCarritos; i++) {
			int intervalo = 10;
			DayOfWeek diaSemana = fecha.getDayOfWeek();
			int diaFinal = diaSemana.getValue();
			LocalTime horaHasta = LocalTime.of(13, 00);
			LocalTime horaDesde = Test.lstTurnos.get(i).getHora();
			Test.lstTurnos.get(i).setOcupado(true);
			agregarDiaRetiro(diaFinal, horaDesde, horaHasta, intervalo);
			System.out.println("El turno esta ocuapdo?:" + " " + Test.lstTurnos.get(i).isOcupado());
		}
		for (int o = 0; o < totalCarritos; o++) {
			if (Test.lstTurnos.get(o).isOcupado() == true) {
				System.out.println(
						"El turno:" + " " + Test.lstTurnos.get(o).getHora() + " " + Test.lstTurnos.get(o).isOcupado());
			}
		}
	}

	public void generarAgenda(LocalDate fecha) {
		for (int i = 0; i < Test.lstTurnos.size(); i++) {
			if (Test.lstTurnos.get(i).isOcupado() == true) {
				System.out.println("El turno numero" + " " + i + " " + "esta ocupado");
			} else {
				System.out.println("El turno numero" + " " + i + " " + "esta libre");
			}
		}
	}

	public void agregarDiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		DiaRetiro d1 = new DiaRetiro(diaSemana, horaDesde, horaHasta, intervalo);
		this.lstDiaRetiro.add(d1);
	}

	public void traerHoraRetiro(LocalDate fecha) {
		for (int i = 0; i < this.lstDiaRetiro.size(); i++) {
			System.out.println("Los horarios de retiro son:" + " " + this.lstDiaRetiro.get(i).getHoraDesde() + " "
					+ this.lstDiaRetiro.get(i).getHoraHasta());
		}
	}

	public boolean validarIdentificadorUnico(long identificador) {
		String identificadorString = Long.toString(identificador);
		char invalido = '2';
		char inicio2= '3';
		char cambiar2pos = '0';
		String charFinal = "9";
		String charFinal2 = "4";
				
		if (identificadorString.charAt(0) != invalido) {
			System.out.println("Cuil invalido");
			return false;
		}
		if (identificadorString.length() == 11){
			if(identificadorString.charAt(1)== inicio2 && identificadorString.endsWith(charFinal)){
				identificadorString.replace(identificadorString.charAt(1),'0');
				System.out.println("Es hombre");
			}
			else if(identificadorString.charAt(1)== inicio2 && identificadorString.endsWith(charFinal2)){
				identificadorString.replace(identificadorString.charAt(1),'7');
				System.out.println("Es mujer");
			}
			// Primer posicion del cuil multiplica por 5
			char suma1 = identificadorString.charAt(0);
			int suma1Final = Character.getNumericValue(suma1);
			suma1Final = suma1Final * 5;

			// Segunda posicion del cuil multiplica por 4
			char suma2 = identificadorString.charAt(1);
			int suma2Final = Character.getNumericValue(suma2);
			suma2Final = suma2Final * 4;

			// Tercera posucuion del cuil multiplica por 3
			char suma3 = identificadorString.charAt(2);
			int suma3Final = Character.getNumericValue(suma3);
			suma3Final = suma3Final * 3;

			// Cuarta posicion del culti multiplica por 2
			char suma4 = identificadorString.charAt(3);
			int suma4Final = Character.getNumericValue(suma4);
			suma4Final = suma4Final * 2;

			// Quienta posicion del cuil multiplica por 7
			char suma5 = identificadorString.charAt(4);
			int suma5Final = Character.getNumericValue(suma5);
			suma5Final = suma5Final * 7;

			// Sexta posicion del cuil multiplica por 6
			char suma6 = identificadorString.charAt(5);
			int suma6Final = Character.getNumericValue(suma6);
			suma6Final = suma6Final * 6;

			// Septicma posicion del cuil multiplica por 5
			char suma7 = identificadorString.charAt(6);
			int suma7Final = Character.getNumericValue(suma7);
			suma7Final = suma7Final * 5;

			// Octava posicion dle cuil multiplica por 4
			char suma8 = identificadorString.charAt(7);
			int suma8Final = Character.getNumericValue(suma8);
			suma8Final = suma8Final * 4;

			// Novena posicion del cuil multiplica por 3
			char suma9 = identificadorString.charAt(8);
			int suma9Final = Character.getNumericValue(suma9);
			suma9Final = suma9Final * 3;

			// Decima posicion del cuil multiplca por 2
			char suma10 = identificadorString.charAt(9);
			int suma10Final = Character.getNumericValue(suma10);
			suma10Final = suma10Final * 2;

			// Se suman todos los resultados
			int sumaFinalTotal = suma1Final + suma2Final + suma3Final + suma4Final + suma5Final + suma6Final
					+ suma7Final + suma8Final + suma9Final + suma10Final;

			// El resultado se divide por 11
			int sumaFinalTotalDivision = sumaFinalTotal / 11;

			// Sacamos el resto de la division
			int restoDeSumaFinal = sumaFinalTotalDivision %2;
			if (restoDeSumaFinal == 0) {
				String cero = "0";
				String uno = "1";
				if (identificadorString.endsWith(cero)) {
					return true;
				}
			}
			if (restoDeSumaFinal == 1) {
				if ((identificadorString.charAt(0) == 2) && ((identificadorString.charAt(1) == 0))) {
					String nueve = "9";
					String cuatro = "4";
					if (identificadorString.endsWith(nueve) && (identificadorString.charAt(0) == 2)
							&& ((identificadorString.charAt(1) == 3))) {
						return true;
					}
					if (identificadorString.endsWith(cuatro) && (identificadorString.charAt(0) == 2)
							&& ((identificadorString.charAt(1) == 3))) {
						return true;
					}
				}
			}
			if ((restoDeSumaFinal != 1) && ((restoDeSumaFinal != 0))) {
				if ((identificadorString.charAt(0) == 2) && ((identificadorString.charAt(1) == 0))) {
					char ultimaPosicion = identificadorString.charAt(10);
					int ultimaPosicionValor = Character.getNumericValue(ultimaPosicion);
					if (identificadorString.charAt(10) == (ultimaPosicionValor - restoDeSumaFinal)) {
						return true;
					} else {
						return false;
					}
				}
				if ((identificadorString.charAt(0) == 2) && ((identificadorString.charAt(1) == 7))) {
					char ultimaPosicion = identificadorString.charAt(10);
					int ultimaPosicionValor = Character.getNumericValue(ultimaPosicion);
					if (identificadorString.charAt(10) == (ultimaPosicionValor - restoDeSumaFinal)) {
						return true;
					} else {
						return false;
					}
				}
			}
		} else {
			System.out.println("Cuil debe contener 11 caracteres");
			return false;
		}
		System.out.println("Fin");
		return true;
	}
}
