package curso;
import java.util.*;

public class Maps {
	public static void main(String [] args) {

		Map<String, String> persona = new HashMap<>();

		persona.put("nombre", "Diego");
		persona.put("Apellido", "Mazza");
		persona.put("Edad", "23");
		persona.put("Edad", "24");
		//SI PONES LA MISMA CLAVE, EL VALOR DE SOBREESCRIBE, NO SE PERMITEN DUPLICADOS
		System.out.println("Valores: ");

		persona.entrySet().forEach(System.out::println);

		System.out.println("Otra forma de hacerlo");

		persona.forEach((k, v)-> System.out.println("Llave " + k + " Valor " + v));
	}

}
