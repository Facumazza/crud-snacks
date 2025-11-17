package maquina_snack_archivos.servicios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import maquina_snack_archivos.dominio.Snack;

public class ServicioSnacksArchivos implements IServicioSnacks{

	private final String NOMBRE_ARCHIVO = "snacks.txt";
	//Crear lista de snacks
	private List<Snack> snacks = new ArrayList<>();

	public ServicioSnacksArchivos() {
		//Creamos archivo si no existe
		var archivo = new File(NOMBRE_ARCHIVO);
		var existe = false;
		try {
			existe = archivo.exists();
			if(existe) {
				this.snacks = obtenerSnacks();
			}else {
				var salida = new PrintWriter(new FileWriter(archivo));
				salida.close();
				System.out.println("Se ha creado el archivo");
			}
		}catch(Exception e) {
			System.out.println("Error al crear el archivo " + e.getMessage());
		}

		//Si no existe, cargamos snacks iniciales
		if(!existe) {
			cargarSnacksIniciales();
		}
	}

	private void cargarSnacksIniciales() {
		this.agregarSnack(new Snack("Papas", 70));
		this.agregarSnack(new Snack("Coca-Cola", 90));
		this.agregarSnack(new Snack("Sanguche", 120));
	}

	private List<Snack> obtenerSnacks(){
		var snacks = new ArrayList<Snack>();
		try {
			List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
			for(String linea: lineas) {
				String[] lineaSnack = linea.split(",");
				var idSnack = lineaSnack[0];
				var nombre = lineaSnack[1];
				var precio = Double.parseDouble(lineaSnack[2]);
				var snack = new Snack(nombre, precio);
				snacks.add(snack);
			}
		}catch(Exception e) {
			System.out.println("Error al leer el archivo" + e.getMessage());
			e.printStackTrace();
		}
		return snacks;
	}

	@Override
	public void agregarSnack(Snack snack) {
		//Agregamos el nuevo snack 1.  a la lista
		this.snacks.add(snack);
		//Agregamos el nuevo snack en el archivo
		this.agregarSnackArchivo(snack);

	}

	private void agregarSnackArchivo(Snack snack) {
		boolean anexar = false;
		var archivo = new File(NOMBRE_ARCHIVO);
		try {
			anexar = archivo.exists();
			var salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(snack.escribirSnack());
			salida.close();
		}catch(Exception e) {
			System.out.println("Error al agregar snack " + e.getMessage());
		}
	}

	@Override
	public void mostrarSnacks() {
		// TODO Auto-generated method stub
		System.out.println("--- Snacks en el inventario ---");
		var inventarioSnacks = "";
		for (var snack: this.snacks) {
			inventarioSnacks += snack.toString() + "\n";
		}
		System.out.println(inventarioSnacks);
	}

	@Override
	public List<Snack> getSnacks() {
		// TODO Auto-generated method stub
		return this.snacks;
	}

}
