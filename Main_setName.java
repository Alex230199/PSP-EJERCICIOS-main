package actividadesRepasoHilos;

public class Main_setName {

	public static void main (String[]args) throws InterruptedException {
		
		Runnable trab1 = new Act3_setName();
		Runnable trab2 = new Act3_setName();
		
		Thread trabajador1 = new Thread(trab1);
		Thread trabajador2 = new Thread(trab2);
		
		trabajador1.setName("Pepe");
		trabajador2.setName("Carla");
		
		System.out.println("Nombre del hilo 1: " + trabajador1.getName());
		System.out.println("Nombre del hilo 2: " + trabajador2.getName());
		
		System.out.println("Trabajador 1 Is Alive (antes de start() ) " + trabajador1.isAlive());
		System.out.println("Trabajador 2 Is Alive (antes de start() )" + trabajador2.isAlive());
		
		trabajador1.start();
		trabajador2.start();
		
		System.out.println("Trabajador 1 Is Alive (despues de start() ) " + trabajador1.isAlive());
		System.out.println("Trabajador 2 Is Alive (despues de start() )" + trabajador2.isAlive());
		
		trabajador1.join();
		trabajador2.join();
		
		System.out.println("Trabajador 1 Is Alive (despues de join() ) " + trabajador1.isAlive());
		System.out.println("Trabajador 2 Is Alive (despues de join() )" + trabajador2.isAlive());
		
		System.out.println("Todos han terminado");
		
	}
}
