package practicaexamen;

public class Main_SetName {
	
	public static void main (String [] args) throws InterruptedException {
		
	

	Runnable trabajador1 = new setName();
	Runnable trabajador2 = new setName();
	
	Thread trab1 = new Thread(trabajador1);
	Thread trab2 = new Thread(trabajador2);
	
	trab1.setName("Pepa");
	trab2.setName("Abelino");
	
	System.out.println("El nombre del hilo 1 es " + trab1.getName());
	System.out.println("El nombre del hilo 2 es " + trab2.getName());
	
	System.out.println("Primera consulta de si el hilo 1 isAlive() " + trab1.isAlive());
	System.out.println("Primera consulta de si el hilo 2 isAlive() " + trab2.isAlive() );
	
	trab1.start();
	trab2.start();
	
	System.out.println("Segunda consulta de si el hilo 1 isAlive() " + trab1.isAlive());
	System.out.println("Segunda consulta de si el hilo 2 isAlive() " + trab2.isAlive());
	
	trab1.join();
	trab2.join();
	
	System.out.println("Tercera consulta de si el hilo 1 isAlive() " + trab1.isAlive());
	System.out.println("Tercera consulta de si el hilo 2 isAlive() " + trab2.isAlive());
	
	System.out.println("Fin del programa");
	
	
	}
}
