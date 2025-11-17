package curso;

import java.io.Serializable;

public class JavaBeans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona = new Persona();

		persona.setNombre("Facu");
		persona.setApellido("Mazza");

		System.out.println(persona);
		System.out.println(persona.getNombre() + " " + persona.getApellido());
	}

}

class Persona implements Serializable{

	private String nombre;
	private String apellido;

	public Persona(){

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + "]";
	}



}
