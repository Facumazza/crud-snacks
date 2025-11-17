package curso;

public interface Traductor{

	void traducir();

	//Metodos con implementacion

	default	void iniciarTraductor() {

		System.out.println("Iniciando traductor");
	}
}


