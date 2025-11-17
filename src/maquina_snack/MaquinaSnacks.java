package maquina_snack;

import java.util.*;

public class MaquinaSnacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		maquinaSnacks();
	}

	public static void maquinaSnacks() {

		var salir = false;
		var consola = new Scanner(System.in);
		//Creamos la lista de productos de tipo snack
		List<Snack> productos = new ArrayList<>();
		System.out.println("*** Maquina de Snacks *** ");
		Snacks.mostrarSnack();//Mostrar el inventario de snacks disponibles

		while(!salir) {
			try {
				var opcion = mostrarMenu(consola);
				salir = ejecutarOpciones(opcion, consola, productos);
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
				4.Salir
				Elige una opción:\s""");

		return Integer.parseInt(consola.nextLine());
	}

	private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos) {

		var salir = false;
		switch(opcion) {

		case 1-> comprarSnack(consola, productos);

		case 2-> mostrarTicket(productos);

		case 3-> agregarSnack(consola);

		case 4->{
			System.out.println("Vuelva pronto!");
			salir = true;
			}
			default -> System.out.println("Opcion invalida: " + opcion);
		}
		return salir;
	}

	private static void comprarSnack(Scanner consola, List<Snack> productos) {

		System.out.println("Que snack queres comprar (id)");

		var idSnack = Integer.parseInt(consola.nextLine());
		//Validacion
		var snackEncontrado = false;

		for(var snack: Snacks.getSnacks()) {

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

	private static void agregarSnack(Scanner consola) {

		System.out.println("Nombre del Snack: ");
		var nombre = consola.nextLine();
		System.out.println("Precio del snack: ");
		var precio = Double.parseDouble(consola.nextLine());
		Snacks.agregarSnack(new Snack(nombre, precio));
		System.out.println("Tu snack se agregó correctamente");
		Snacks.mostrarSnack();
	}
}


















