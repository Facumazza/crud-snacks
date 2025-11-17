package maquina_snack_archivos.dominio;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable{

	private static int contadorSnacks = 0;
	private int idSnack;
	private String nombre;
	private double precio;

	public Snack() {

		this.idSnack = ++Snack.contadorSnacks; //Se incremente y se guarda en idSnack
	}

	public Snack(String nombre, double precio) {
		this();
		this.nombre = nombre;
		this.precio = precio;

	}

	public static int getContadorSnacks() {
		return contadorSnacks;
	}

	public int getIdSnack() {
		return idSnack;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Snack [idSnack=" + idSnack + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	public String escribirSnack() {
		return idSnack + "," + nombre + "," + precio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idSnack, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Snack other = (Snack) obj;
		return idSnack == other.idSnack && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}
}







