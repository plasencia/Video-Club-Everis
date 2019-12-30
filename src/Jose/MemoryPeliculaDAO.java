package Jose;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sun.security.action.GetBooleanAction;

public class MemoryPeliculaDAO {

	private String cadena;
	private String entrada;
	@SuppressWarnings("unused")
	private static Scanner menu;
	private static boolean salir;
	@SuppressWarnings("unused")
	private static int opcion;
	 // Lo ponemos static por que solo se usará en esta clase.
	// También lo ponemos al principio de la clase para que pueda ser usado de forma genérica en cualquier sub-clase creada.
	static ArrayList<PeliculaTO> lista = new ArrayList<PeliculaTO>();
	static Boolean cargar = false;
	private static Scanner scanner;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
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
			System.out.println("6. Modificar una Pelicula.");
			System.out.println("7. Salir de la aplicacion");
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
				ModificarPeliculas();
				break;
			case 7:
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
		@SuppressWarnings({ "resource", "unused" })
		Scanner scanner = new Scanner(System.in);
		List<PeliculaTO> list = new ArrayList<PeliculaTO>();

		if (cargar == false) {
			System.out.println("");
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
			// Inicializo la variable cargar a true para que una vez que tenga la lista
			// cargada no me la vuelva a duplicar.
			cargar = true;
		} else {
			System.out.println("");
			System.out.println("**************************");
			System.out.println("La lista ya esta cargada.");
			System.out.println("");
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

	public static void ListarPeliculasIdentificador() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean verdad = false;
		ArrayList<PeliculaTO> contenido = new ArrayList<PeliculaTO>();

		System.out.println(" Vamos a listar peliculas mediante su Titulo: ");
		System.out.println("**************************************************");
		System.out.println("Introduce su identificador: ");
		System.out.println("**************************************************");
		String identificador = scanner.nextLine();

		for (PeliculaTO peli : lista) {
			if (identificador.equalsIgnoreCase(peli.getCodigopelicula())) {
				verdad = true;
				contenido.add(peli);
			}
		}
		if (verdad == true) {
			System.out.println("");
			System.out.println("*****************************");
			System.out.println("Mostrando la pelicula deseada");
			System.out.println("*****************************");
			System.out.println("");
			System.out.println(contenido);
		} else {
			System.out.println("*****************************");
			System.out.println("La pelicula con el identificador: " + identificador
					+ " no se encuentra disponible en nuestra Base de datos.");
			System.out.println("*****************************");
		}
		System.out.println("");
		System.out.println("*****************************");
		System.out.println("Desea usted volver a comprobar otro identificador de pelicula en nuestra base de datos.");
		System.out.println("*****************************");
		String comprobador = scanner.nextLine();
		if ("si".equalsIgnoreCase(comprobador)) {
			ListarPeliculasIdentificador();
		}
	}

	public static void EliminarPeliculas() throws InterruptedException {
		scanner = new Scanner(System.in);
		System.out.println("Introduce el Identificador de la pelicual que desea usted eliminar de la lista: ");
		String borrar = scanner.nextLine();
		boolean verdad = false;
		ArrayList<PeliculaTO> mostrar = new ArrayList<PeliculaTO>();
		for (PeliculaTO peli : lista) {

			if (borrar.equalsIgnoreCase(peli.getCodigopelicula())) {
				verdad = true;
				mostrar.add(peli);
			}
		}
		// Cuando borrar = PeliculaTO.getIdentificador();
		if (verdad == true) {
			System.out.println("");
			System.out.println("La pelicula que desea usted borrar es la siguiente: ");
			System.out.println("");
			System.out.println("**********************************");
			System.out.println(mostrar);
			System.out.println("**********************************");
		} else {
			System.out.println("**********************************");
			System.out.println("No existe la pelicula: " + borrar);
			System.out.println("**********************************");
		}
		// Preguntamos si queremos volver a introducir otro identificador para realizar
		// otro borrado de alguna pelicula que se encuentre en nuestra base de datos.
		System.out.println(
				"Desea volver a introducir otro identificador para borrar una pelicula existente en nuestra Base de Datos: ");
		String deseo = scanner.nextLine();
		if (deseo.equalsIgnoreCase("si")) {
			EliminarPeliculas();
		}
	}

	public static void ModificarPeliculas() {

		scanner = new Scanner(System.in);
		System.out.println("**********************");
		System.out.println("Introduce el identificador de la pelicula que desea modificar: ");
		String modificar = scanner.nextLine();
		System.out.println("**********************");
		boolean verdad = false;
		System.out.println("");

		for (PeliculaTO peli : lista) {
			if (modificar.equalsIgnoreCase(peli.getCodigopelicula())) {
				verdad = true;
				System.out.println("Introduce el titulo: ");
				String titulo = scanner.nextLine();
				peli.setCodigopelicula(titulo);

				System.out.println("Introduce el codigo de la pelicula: ");
				String codigo = scanner.nextLine();
				peli.setTitulo(codigo);

				System.out.println("Introduce el actor: ");
				String actor = scanner.nextLine();
				peli.setActor(actor);

				System.out.println("Introduce el director: ");
				String director = scanner.nextLine();
				peli.setDirector(director);
			}
		}
		if (verdad == true) {
			System.out.println("");
			System.out.println("Imprimiendo por pantalla la lista modificada: ");
			System.out.println("**********************************************");
			 // Volvemos a iniciar el bucle for para que nos imprima los datos divididos en columnas.
			for(PeliculaTO datos : lista) {
			System.out.println(datos);
			}
			System.out.println("**********************************************");
			System.out.println("¿ Desea volver a introducir un codigo de pelicula ?");
			String volver = scanner.nextLine();
			if ("si".equalsIgnoreCase(volver)) {
				ModificarPeliculas();
			}
		} else {
			System.out.println("-------------------------------------------");
			System.out.println("El identificador " + "[" + modificar + "]" + " no existe");
			System.out.println("-------------------------------------------");
			System.out.println("¿ Desea volver a introducir un codigo de pelicula ?");
			String volver = scanner.nextLine();
			if ("si".equalsIgnoreCase(volver)) {
				ModificarPeliculas();
			}
		}
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
