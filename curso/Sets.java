package curso;

import java.util.*;

public class Sets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//No se permiten duplicados
		Set<String> conjunto = new TreeSet<>();

		conjunto.add("Buenas");
		conjunto.add("aloo");

		conjunto.forEach(System.out::println);

		conjunto.remove("aloo");

		System.out.println("Sacamos a aloo");
		conjunto.forEach(System.out::println);
	}

}
