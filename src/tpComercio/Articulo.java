package tpComercio;
import tpComercio.ItemCarrito;

public class Articulo {
	private static final boolean String = false;
	private int id;
	private String nombre;
	private String codBarras;
	private double precio;

	public Articulo(int id, String nombre, String codBarras, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.codBarras = codBarras;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	boolean validarCodBarr(String codBarr) {
		boolean determinador = true;
		int i = 0;
		int suma1 = 0;
		int suma2 = 0;
		int sumaFinalImpares = 0;
		int sumaFinal = 0;
		int sumaFinal10 = 0;
		int contador = 0;
		int s1 = 0;
		int s2 = 0;
		
		if (codBarr.length() != 13) {
			System.out.println("Codigo de barra no cuenta con 13 digitos");
			determinador = false;
			return determinador;
		}
			for (i = 0; i < 3; i++) {
				if (i == 0) {
					if (codBarr.charAt(i) != '7') {
						determinador = false;
						if (determinador == false) {
							System.out.println("Primer digito debe ser 7");
							i = 3;
						}
					}
					}
					if (i == 1) {
						if (codBarr.charAt(i) != '7') {
							determinador = false;
							if (determinador == false) {
								System.out.println("Segundo digito debe ser 7");
								i = 3;
								return determinador;
							}
						}
						}
						if (i == 2) {
							if (codBarr.charAt(i) != '9') {
								determinador = false;
								if (determinador == false) {
									System.out.println("Tercer digito debe ser 9");
									i = 3;
									return determinador;
								}
							}
						}
					}	
			if (determinador == true) {
				for (i = 0; i < codBarr.length()-1; i++) {
					if (i %2 != 0) {
						s1 = Character.getNumericValue((codBarr.charAt(i)));
						System.out.println("s1 vale ahora:" + s1 +"y suma1 :" + suma1);
						System.out.println("la posicion es:" + codBarr.charAt(i));
						suma1 = suma1 + s1;
					}
				}
				
				sumaFinalImpares = suma1 * 3;
				
				for (i = 0; i < codBarr.length()-1; i++) {
					if (i %2 == 0) {
						s2 = Character.getNumericValue((codBarr.charAt(i)));
						suma2 = suma2 + s2;
					}
				}
				System.out.println(sumaFinalImpares + "suma2"+" "+ suma2);
				sumaFinal = sumaFinalImpares + suma2;
				sumaFinal10 = sumaFinal;
				System.out.println(sumaFinal10);
				while (sumaFinal10 %10 != 0) {
					sumaFinal10 = sumaFinal10 + 1;
					contador = contador + 1;
					System.out.println("El numero que se tiene que sumar para que sea multiplo de 10 es :" + contador);
				}
				System.out.println(determinador);
				System.out.println(codBarr.charAt(codBarr.length()-1));
				System.out.println(contador);
				int c1 = Character.getNumericValue((codBarr.charAt(codBarr.length()-1)));
				System.out.println(c1 + "=" + " " + contador);
				if(c1 != contador){
					determinador = false;
				}
				System.out.println(codBarr);
		}
		return determinador;
	}
	
}