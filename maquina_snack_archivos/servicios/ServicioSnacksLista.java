package maquina_snack_archivos.servicios;

import java.util.*;

import maquina_snack_archivos.dominio.Snack;

public class ServicioSnacksLista implements IServicioSnacks{

	private static final List<Snack> snacks;

	//BLOQUE STATIC INICIALIZADOR
	static {
		snacks = new ArrayList<>();
		snacks.add(new Snack("Papas", 70));
		snacks.add(new Snack("Bebida", 50));
		snacks.add(new Snack("Sanguche", 120));
	}

	public void agregarSnack(Snack snack) {

		snacks.add(snack);
	}

	public void mostrarSnacks() {

		var inventarioSnacks = "";

		for(var snack: snacks) {
			inventarioSnacks += snack.toString() + "\n";
		}

		System.out.println("--- Snacks en el inventario---");
		System.out.println(inventarioSnacks);
	}

	public List<Snack> getSnacks(){
		return snacks;
	}
}
