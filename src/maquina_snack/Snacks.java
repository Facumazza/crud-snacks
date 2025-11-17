package maquina_snack;

import java.util.*;

public class Snacks {

	private static final List<Snack> snacks;

	//BLOQUE STATIC INICIALIZADOR
	static {
		snacks = new ArrayList<>();
		snacks.add(new Snack("Papas", 70));
		snacks.add(new Snack("Bebida", 50));
		snacks.add(new Snack("Sanguche", 120));
	}

	public static void agregarSnack(Snack snack) {

		snacks.add(snack);
	}

	public static void mostrarSnack() {

		var inventarioSnacks = "";

		for(var snack: snacks) {
			inventarioSnacks += snack.toString() + "\n";
		}

		System.out.println("--- Snacks en el inventario---");
		System.out.println(inventarioSnacks);
	}

	public static List<Snack> getSnacks(){
		return snacks;
	}
}
