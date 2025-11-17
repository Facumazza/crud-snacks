package maquina_snack_archivos.presentacion;

import java.util.*;

import maquina_snack_archivos.dominio.Snack;
import maquina_snack_archivos.servicios.ServicioSnacksLista;
import maquina_snack_archivos.servicios.*;

public class MaquinaSnacks {

	public static void main(String[] args) {

		maquinaSnacks();
	}

	public static void maquinaSnacks() {

		var salir = false;
		var consola = new Scanner(System.in);
		//Creamos el objeto
		//IServicioSnacks servicioSnacks = new ServicioSnacksLista();
		IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();
		//Creamos la lista de productos de tipo snack
		List<Snack> productos = new ArrayList<>();
		System.out.println("*** Maquina de Snacks *** ");
		servicioSnacks.mostrarSnacks();//Mostrar el inventario de snacks disponibles

		while(!salir) {
			try {
				var opcion = mostrarMenu(consola);
				salir = ejecutarOpciones(opcion, consola, productos, servicioSnacks);
			}catch(Exception e) {
				System.out.println("ERROR: " + e.getMessage());
			}finally{
				System.out.println();//imprime salto de linea en cada iteracion
			}
		}
	}

	private static int mostrarMenu(Scanner consola) {
		// TODO Auto-generated method stub
		System.out.println("""
				Menu:
				1.Comprar Snack
				2.Mostrar Ticket
				3.Agregar nuevo Snack
				4.Inventario Snack
				5.Salir
				Elige una opción:\s""");

		return Integer.parseInt(consola.nextLine());
	}

	private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks) {

		var salir = false;
		switch(opcion) {

		case 1-> comprarSnack(consola, productos, servicioSnacks);

		case 2-> mostrarTicket(productos);

		case 3-> agregarSnack(consola, servicioSnacks);

		case 4-> listarInventarioSnacks(consola, servicioSnacks);

		case 5->{
			System.out.println("Vuelva pronto!");
			salir = true;
			}
			default -> System.out.println("Opcion invalida: " + opcion);
		}
		return salir;
	}

	private static void listarInventarioSnacks(Scanner consola, IServicioSnacks servicioSnacks) {
		servicioSnacks.mostrarSnacks();
	}

	private static void comprarSnack(Scanner consola, List<Snack> productos, IServicioSnacks servicioSnacks) {

		System.out.println("Que snack queres comprar (id)");

		var idSnack = Integer.parseInt(consola.nextLine());
		//Validacion
		var snackEncontrado = false;

		for(var snack: servicioSnacks.getSnacks()) {

			if(idSnack == snack.getIdSnack()) {
 				//Agregamos el snack a la lista
				productos.add(snack);
				System.out.println("Snack agregado! " +snack);
				snackEncontrado = true;
				break;
			}
		}

		if(!snackEncontrado) {

			System.out.println("ID de snack no encontrado! " + idSnack);
		}
	}

	private static void mostrarTicket(List<Snack> productos) {

		var ticket = "*** Ticket de Venta ***";
		var total = 0.0;
		for(var producto: productos) {
			ticket += "\n\t- " + producto.getNombre() + " - $" + producto.getPrecio();
			total += producto.getPrecio();
		}
		ticket += "\n\t Precio total-> $" + total;
		System.out.println(ticket);
	}

	private static void agregarSnack(Scanner consola,  IServicioSnacks servicioSnacks ) {

		System.out.println("Nombre del Snack: ");
		var nombre = consola.nextLine();
		System.out.println("Precio del snack: ");
		var precio = Double.parseDouble(consola.nextLine());
		servicioSnacks.agregarSnack(new Snack(nombre, precio));
		System.out.println("Tu snack se agregó correctamente");
		servicioSnacks.mostrarSnacks();
	}
}


















