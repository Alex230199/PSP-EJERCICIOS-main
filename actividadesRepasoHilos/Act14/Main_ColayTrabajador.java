package actividadesRepasoHilos.Act14;

public class Main_ColayTrabajador {
	
	/*
	 Conceptos: Runnable, synchronized, wait, notifyAll e interrupciones.
Un trabajador recogerá encargos de una cola compartida, en el orden de llegada. Main añadirá cinco 
encargos identificados del 1 al 5 y podrá detener el servicio.
1. Implementa añadir() y extraer() con el mismo monitor. extraer() esperará con while y wait()
cuando la cola esté vacía; añadir() insertará el encargo y avisará con notifyAll().
2. Procesar un encargo consistirá en dormir 300 ms fuera del monitor. Solo se considera completado si 
esa pausa termina normalmente.
3. Main arrancará al trabajador, añadirá los cinco encargos, esperará unos 500 ms y lo interrumpirá. El 
trabajador atenderá la petición antes de recoger otro encargo y también si se interrumpe su espera o 
su pausa.
4. Después de join(), main mostrará tres listas: completados; retirado de la cola pero cancelado antes 
de completarse, si lo hay; y pendientes en la cola. Repite con la cola vacía desde el inicio.
COMPRUEBA
En la primera prueba, los cinco identificadores aparecen una sola vez entre las tres listas. No se exige un 
reparto concreto. En ambas pruebas, el trabajador termina y no queda esperando.
EXPLICA
¿Por qué un encargo retirado de la cola no puede contarse automáticamente como completado?
	 */
	
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

