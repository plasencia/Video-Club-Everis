package Jose;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import sun.security.util.Length;

public class MemoryPeliculaDAO {

	private String cadena;
	private String entrada;
	private static Scanner menu;
	private static boolean salir;
	private static int opcion;
	static ArrayList<PeliculaTO> lista = new ArrayList<PeliculaTO>();
	static Boolean cargar = false;
	private static Scanner scanner;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);

		System.out.println("**********************************************************");
		System.out.println("Bienvenido al Video Club Everis, que desea hacer");
		System.out.println("**********************************************************");
		System.out.println("");
		menu = new Scanner(System.in);
		salir = false;
		int opcion;

		while (!salir) {
			System.out.println("***************");
			System.out.println("");
			System.out.println("1. Cargar Peliculas.");
			System.out.println("2. Agregar Peliculas.");
			System.out.println("3. Listar Peliculas.");
			System.out.println("4. Listar Peliculas mediante su Identificador.");
			System.out.println("5. Eliminar Peliculas dado su Identificador.");
			System.out.println("6. Salir de la aplicacion");
			System.out.println("");

			System.out.println("Elige una de estas opciones");
			opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				CargarCatalogo();
				break;
			case 2:
				AgregarPeliculas();
				break;
			case 3:
				ListarPeliculas();
				break;
			case 4:
				ListarPeliculasIdentificador();
				break;
			case 5:
				EliminarPeliculas();
				break;
			case 6:
				System.out.println("Has pulsado en salir, hata pronto");
				salir = true;
				break;
			default:
				System.out.println("Debes introducir un numero que este en la lista.");

				opcion = entrada.nextInt();
			}
		}
	}

	public static List<PeliculaTO> CargarCatalogo() throws InterruptedException {
		// Intentar evitar varias veces las mísmas peliculas.
		Scanner scanner = new Scanner(System.in);
		List<PeliculaTO> list = new ArrayList<PeliculaTO>();

			if (cargar == false) {
				
				System.out.println("El catalogo en primer instante se encuentra vacio ... ");
				System.out.println("Cargando Peliculas almacenadas en la Base de Datos de Everis: ");
				System.out.println("***************************************************************");

				lista.add(new PeliculaTO("Cazador de Demonios 0", "145asd", "jhon", "pepe"));
				lista.add(new PeliculaTO("Cazador de Demonios 1", "245asd", "javi", "papa"));
				lista.add(new PeliculaTO("Cazador de Demonios 2", "345asd", "poek", "porqa"));
				lista.add(new PeliculaTO("Cazador de Demonios 3", "445asd", "claroq", "aqrrf"));
				lista.add(new PeliculaTO("Cazador de Demonios 4", "745asd", "arpqo", "adsf"));
				System.out.println("");
				System.out.println("");

				for (PeliculaTO a : lista) {
					if (!lista.isEmpty()) {
						// Cada 2 segundo carga una pelicula que tenga almacenada en la base de datos.
						// Thread.sleep(2000);
						System.out.println(a);
						list.add(a);
					}

				}
				// Inicializo la variable cargar a true para que una vez que tenga la lista cargada no me la vuelva a duplicar.
				cargar = true;
			} else {
				System.out.println("La lista ya esta cargada.");
			}
		return list;

	}

	public static void AgregarPeliculas() {

		System.out.println("");
		System.out.println("Listando Peliculas : ");
		System.out.println("***************************************************");

		for (PeliculaTO a : lista) {
			System.out.println(a);
		}
		System.out.println("****************************************************");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("***************");
		System.out.println("Vamos añadir una nueva pelicula.");
		System.out.println("***************");

		System.out.print("Ingresa el Titulo: ");
		String titulo = scanner.nextLine();
		System.out.print("Ingresa el Código de la Pelicula: ");
		String codigopelicula = scanner.nextLine();
		System.out.print("Ingresa el Actor: ");
		String actor = scanner.nextLine();
		System.out.print("Ingresa el Director: ");
		String director = scanner.nextLine();

		System.out.println("****************************************************************");
		System.out.println("Mostrando Listado de peliculas Actualizado");
		System.out.println("****************************************************************");
		System.out.println("");

		lista.add(new PeliculaTO(titulo, codigopelicula, actor, director));

		for (PeliculaTO a : lista) {
			System.out.println(a);
		}
	}

	public static void ListarPeliculas() throws InterruptedException {

		System.out.println("");
		System.out.println("****************************************************************");
		System.out.println(" Bienvenido a la lista de las peliculas del video club EVERIS: ");
		System.out.println("****************************************************************");
		System.out.println(" Mostrando lista a Continuación: ");
		System.out.println("****************************************************************");

		for (PeliculaTO peli : lista) {
			if (peli != null) {
				System.out.println(peli);
			} else {
				System.out.println("Error es nulo PeliculaTO");
			}
		}
	}

	public static List<PeliculaTO> ListarPeliculasIdentificador() throws InterruptedException {

		Scanner scanner = new Scanner(System.in);
		System.out.println(" Vamos a listar peliculas mediante su Titulo: ");
		System.out.println("");
		System.out.println("Introduce su identificador");
		String identificador = scanner.nextLine();
		
		for(PeliculaTO peli : lista) {
			
			if (identificador.equalsIgnoreCase(peli.getCodigopelicula())) {
				System.out.println("");
				System.out.println("Mostrando la pelicula deseada");
				System.out.println("*****************************");
				System.out.println(peli);
				break;
			}else {
				System.out.println("Este título no se encuentra en nuestra Base de datos");
				break;
			}
		}
	
		return lista;

	}

	
	public static List<PeliculaTO> EliminarPeliculas() throws InterruptedException {
		scanner = new Scanner(System.in);
		System.out.println("Introduce el Identificador de la pelicual que desea usted eliminar de la lista: ");
		String borrar= scanner.nextLine();
		
		for(PeliculaTO peli : lista) {
			if(borrar.equalsIgnoreCase(peli.getCodigopelicula())) {
				System.out.println("");
				System.out.println("La pelicula que desea usted borrar es la siguiente: ");
				System.out.println("");
				System.out.println(peli);
				break;
			}
		}
		return lista;
	}

	
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
}
