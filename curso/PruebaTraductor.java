package curso;

public class PruebaTraductor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Traductor ingles = new Ingles();

		ingles.iniciarTraductor();
		ingles.traducir();

		System.out.println("-----------------------------------");

		Traductor frances = new Frances();

		frances.iniciarTraductor();
		frances.traducir();

	}

}
class Ingles implements Traductor{

	@Override
	public void traducir() {
		// TODO Auto-generated method stub
		System.out.println("Traduzco en ingles");
	}


}


class Frances implements Traductor{

	@Override
	public void traducir() {
		// TODO Auto-generated method stub
		System.out.println("Traduzco en frances");
	}

	@Override
	public void iniciarTraductor() {

		System.out.println("Iniciar traductor en frances... ");
	}

}