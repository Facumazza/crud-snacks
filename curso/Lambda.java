package curso;

import java.util.*;

public class Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> lista = new ArrayList<>();

		lista.add("Hola");
		lista.add("Mi amor");
		lista.add("Como estas?");

		//Funcion lambda
		/*lista.forEach(mensaje ->{
			System.out.println(mensaje);
		});*/

		//Lo mismo pero mas resumido. :: los dobles puntos nos permite entrar en un metodo static
		lista.forEach(System.out::println);

		List<String> nombres = Arrays.asList("Facu", "Aylu");
		nombres.forEach(System.out::println);
	}

}
