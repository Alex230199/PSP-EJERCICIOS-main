package actividadesRepasoHilos;

public class Main_TareasyPool {

	public static void main(String [] args) throws InterruptedException{
		
		//PRUEBA NUMERO 1
		
		System.out.println("PRUEBA 1: Cierre normal (12 tareas) ");
		
		Act19_Pool servicio1 = new Act19_Pool();
		
		Act19_Trabajador t1 = new Act19_Trabajador(servicio1);
		Act19_Trabajador t2 = new Act19_Trabajador(servicio1);
		Act19_Trabajador t3 = new Act19_Trabajador(servicio1);
		
		Thread h1 = new Thread (t1);
		Thread h2 = new Thread (t2);
		Thread h3 = new Thread (t3);
		
		h1.start();
		h2.start();
		h3.start();
		
		int rechazadas1 = 0;
		for (int i = 1; i <= 12; i++) {
			boolean aceptada = servicio1.enviar(new Act19_Tarea(i));
			
			if (!aceptada) rechazadas1++;
		}
		
		servicio1.cerrar();
		
		h1.join();
		h2.join();
		h3.join();
		
		System.out.println("Completadas: " + (t1.getCompletadas() + t2.getCompletadas() + t3.getCompletadas()));
		
		System.out.println("Rechazadas: " + rechazadas1);
	
		//PRUEBA NUMERO 2
		
		System.out.println("PRUEBA 2: Cancelación con trabajo pendiente");
		
		Act19_Pool servicio2 = new Act19_Pool();
		
		Act19_Trabajador t4 = new Act19_Trabajador(servicio2);
		Act19_Trabajador t5 = new Act19_Trabajador(servicio2);
		Act19_Trabajador t6 = new Act19_Trabajador(servicio2);
		
		Thread h4 = new Thread(t4);
		Thread h5 = new Thread(t5);
		Thread h6 = new Thread(t6);
		
		h4.start();
		h5.start();
		h6.start();
		
		for(int i = 1; i <= 8; i++) {
			servicio2.enviar(new Act19_Tarea(i));
			
		}
		
		Thread.sleep(100);
		
		Act19_Tarea[] pendientes = servicio2.cancelarAhora();
		
	System.out.println("Tareas retiradas de la cola por cancelarAhora: " + pendientes.length);
	
	h4.interrupt();
	h5.interrupt();
	h6.interrupt();
	
	h4.join();
	h5.join();
	h6.join();
	
	System.out.println("Completadas antes de cancelar: " + (t4.getCompletadas() + t5.getCompletadas() + t6.getCompletadas()));
	System.out.println("Canceladas en curso: " + (t4.getCanceladasEnCurso() + t5.getCanceladasEnCurso() + t6.getCanceladasEnCurso()));
	
	
	
	// PRUEBA NUMERO 3 - CIERRE MIENTRAS UN HILO INTENTA ENVIAR
	
	System.out.println("PRUEBA 3: Cierre mientras se intenta enviar");
	
	Act19_Pool servicio3 = new Act19_Pool();
	
	for (int i = 1; i<= 4; i++) {
		servicio3.enviar(new Act19_Tarea(i));
		
	}
	
	Thread henvio = new Thread (() -> {
		
		try {
			
			boolean intento = servicio3.enviar(new Act19_Tarea(100));
			System.out.println("Resultado de enviar con servicio cerrándose: " + intento);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	});
	
	henvio.start();
	
	Thread.sleep(20);
	servicio3.cerrar();
	
	henvio.join();
	System.out.println("Fin de la prueba numero 3");
	
	}
	
	
}
