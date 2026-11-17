package actividadesRepasoHilos;

public class Main_TurnoDeLetras {

	public static void main (String [] args) throws InterruptedException {
		
		
		System.out.println("===PRUEBA NORMAL===");
		Act15_ControlTurno control1 = new Act15_ControlTurno();
		Thread hilo1 = new Thread (new Act15_Letras(control1, 'A'));
		Thread hilo2 = new Thread (new Act15_Letras(control1, 'B'));
		
		hilo1.start();
		hilo2.start();
		
		
		hilo1.join();
		hilo2.join();
		
		System.out.println();
		
		
		System.out.println("===PRUEBA CON INTERRUPCION");
		Act15_ControlTurno control2 = new Act15_ControlTurno();
		Thread hiloB1 = new Thread (new Act15_Letras(control2, 'A'));
		Thread hiloB2 = new Thread (new Act15_Letras(control2, 'B'));
		
		hiloB1.start();
		hiloB2.start();
		
		Thread.sleep(15);
		hiloB1.interrupt();
		
		hiloB1.join();
		hiloB2.join();
		
		System.out.println("Fin de las pruebas");
	}
}
