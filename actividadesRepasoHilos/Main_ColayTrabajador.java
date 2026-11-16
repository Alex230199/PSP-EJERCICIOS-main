package actividadesRepasoHilos;

public class Main_ColayTrabajador {
	 public static void main (String [] args) throws InterruptedException {
		 
		 System.out.println("=== Prueba 1: 5 encargos e interrupcion ===");
		 Act14_Cola cola1 = new Act14_Cola();
		 Act14_Trabajador trabajador1 = new Act14_Trabajador(cola1);
		 Thread hilo1 = new Thread(trabajador1);
		 
		 hilo1.start();
		 
		 for (int i = 1; i<= 5; i++) {
			 cola1.añadir(i);
		 }
		 
		 Thread.sleep(500);
		 hilo1.interrupt();
		 hilo1.join();
		 
		 imprimirListas(
				 trabajador1.getCompletados(),
				 trabajador1.tieneCancelado() ? new int [] {trabajador1.getCancelado()} : new int[0],
				 cola1.getPendientes()
 				 );
		 
		 
		 System.out.println("=== Prueba 2: cola vacia desde el inicio ===");
		 Act14_Cola cola2 = new Act14_Cola();
		 Act14_Trabajador trabajador2 = new Act14_Trabajador(cola2);
		 Thread hilo2 = new Thread(trabajador1);
		 
		 hilo2.start();
		 Thread.sleep(200);
		 hilo2.interrupt();
		 hilo2.join();
		 
		 imprimirListas(
				 trabajador2.getCompletados(),
				 trabajador2.tieneCancelado() ? new int [] {trabajador2.getCancelado()} : new int[0],
				 cola2.getPendientes()
 				 );
		 
	 }
	 
	 private static void imprimirListas (int[] completados, int[] cancelado, int[] pendientes) {
		 
		 System.out.println("completados: [");
		 for (int i = 0; i < completados.length; i++) {
			 System.out.println(completados[i] + (i <completados.length - 1 ? "," : ""));
			 
		 }
		 
		 System.out.println("]");
		 
		 System.out.println("Retirado pero cancelado: [");
	        for (int i = 0; i < cancelado.length; i++) {
	            System.out.print(cancelado[i] + (i < cancelado.length - 1 ? ", " : ""));
	        }
	        System.out.println("]");

	        System.out.print("Pendientes en la cola: [");
	        for (int i = 0; i < pendientes.length; i++) {
	            System.out.print(pendientes[i] + (i < pendientes.length - 1 ? ", " : ""));
	        }
	        System.out.println("]");
	    }
	 }

