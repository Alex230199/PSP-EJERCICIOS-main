package ACT_HILOS;

public class Main {

	public static void main (String [] args) {
		//Contador c1 = new Contador(500);
		//ContadorNombrado cn = new ContadorNombrado(500, "Fonsi");
		//ContadorNombrado rapido = new ContadorNombrado(200, "Rapido");
		//ContadorNombrado lento = new ContadorNombrado(700, "Lento");
		Animal tortuga = new Animal ("Tortuga", 0, 600,2);
		Animal liebre = new Animal ("Liebre", 0, 200,1);
		Animal pajaro = new Animal ("Pajaro", 0, 350, 3);
		
		/*c1.start();
		cn.start();
		rapido.start();
		lento.start();
		*/
		tortuga.start();
		liebre.start();
		pajaro.start();
		
		//System.out.println("El hilo principal continua");
	}
}
