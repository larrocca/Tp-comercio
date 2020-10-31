package tpComercio;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import tpComercio.Cliente;
import tpComercio.Articulo;
import java.time.*;
import java.time.format.*;
import tpComercio.Entrega;
import tpComercio.RetiroLocal;
import tpComercio.Carrito;
import tpComercio.ItemCarrito;
import tpComercio.Envio;


public class Test {
	
	public static List<Turno>lstTurnos= new ArrayList<Turno>();
	
	
	public static void main(String[] args) {
		//Variables utiles
		Contacto con1 = null;
		String determinador2 = null;
		boolean finalDeterminador = true;
		LocalDate l1= LocalDate.of(1998, 2, 3);
		int i=54;
		LocalTime l2 = LocalTime.now();
		LocalDate fecha = LocalDate.now();
		long cuit = 23404306979L;
		
		//Al principio creamos todos los objetos necesarios para el test
		
		//Crea una ubicacion y contacto
		Ubicacion ubicacion1 = new Ubicacion(40,40);
		Contacto contacto1 = new Contacto("asdasd", "11223344", "jorge");
		
		//Se crea el comercio
		Comercio comercio1 = new Comercio(1,contacto1);
		
		//Crea clientes
		Cliente c2 = new Cliente(403490,con1,"Gimenez","Raul",40430697);
		Cliente c7 = new Cliente(403490,con1,"Gimenez","Carlos",40430697);
		
		//Crea listas vacias para setearlas con funciones
		List<ItemCarrito>lstCarritos = new ArrayList<ItemCarrito>();
		List<Carrito>lstCarrito = new ArrayList<Carrito>();
		List<DiaRetiro>lstDiaRetiro = new ArrayList<DiaRetiro>();
		
		//Crfeamos turnos, carritos y entregas para poder testear
		Turno turno= new Turno(l1,l2);
		Carrito c1 = new Carrito(0, true, 0, c2, lstCarritos);
		Carrito c3 = new Carrito(0, true, 0, c2, lstCarritos);
		Carrito c4 = new Carrito(0, true, 0, c2, lstCarritos);
		Carrito carrito2 = new Carrito(0, true, 0, c2, lstCarritos);
		Carrito carrito5 = new Carrito(0, true, 0, c7, lstCarritos);
		Entrega e1 = new RetiroLocal(1, fecha);
		Entrega e2 = new Envio(1, fecha);
		Entrega e3 = new RetiroLocal(1, fecha);
		
		//Seteamos entregas, fechas
		c1.setEntrega(e1);
		carrito5.setEntrega(e2);
		carrito2.setEntrega(e3);
		c1.setFecha(fecha);
		carrito2.setFecha(fecha);
		carrito5.setFecha(l1);
		
		//Agregamos a las listas que corresponden
		lstCarrito.add(c1);
		lstCarrito.add(carrito2);
		lstCarrito.add(c3);
		lstCarrito.add(c4);
		lstCarrito.add(carrito5);
		comercio1.setLstCarrito(lstCarrito);
		comercio1.setLstDiaRetiro(lstDiaRetiro);
		comercio1.generarTurnosLibres(l1);
		comercio1.generarTurnosOcupados(fecha);
		comercio1.generarAgenda(fecha);
		comercio1.traerHoraRetiro(fecha);
		comercio1.setCuit(cuit);
		//Validar DNI
		c2.validarIdentificadorUnico(c2.getDni());
		comercio1.validarIdentificadorUnico(comercio1.getCuit());
		
//Todo lo comentado apartir de ahora es para el funcionamiento de validar dni que se ingrese manualmente
//		Articulo art1 = new Articulo (123,"jorge","7791211241286",23.4);
//		finalDeterminador = art1.validarCodBarr(art1.getCodBarras());
//		System.out.println(finalDeterminador);
//		
		// TODO Auto-generated method stub
//		Cliente c1 = new Cliente(403490,con1,"Gimenez","Raul","402adsas","h");
//		c1.validarIdentificadorUnico(c1.getDni());
//		System.out.println("El DNI es :" + c1.getDni());
		
		//Las lineas comentadas es para el ingreso de DNI por el usuario
		/*
		System.out.println("Ingrese DNI");
		try (Scanner sc = new Scanner (System.in)) {
			determinador2 = sc.nextLine();
			finalDeterminador = c1.validarIdentificadorUnico(determinador2);
				if(finalDeterminador == false) {
					determinador2 = null;
				}
			c1.setDni(determinador2);
		}
		if(finalDeterminador == true){
		System.out.println("El DNI es:" + c1.getDni());
		}
		if(finalDeterminador == false) {
			System.out.println("Ingrese DNI nuevamente");
		}
	}*/
		
	}

}
