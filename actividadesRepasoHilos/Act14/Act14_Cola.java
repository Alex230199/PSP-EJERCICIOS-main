package actividadesRepasoHilos.Act14;

public class Act14_Cola {
	
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

	private int[] elementos = new int[10];
	private int inicio = 0;
	private int fin = 0;
	private int cantidad = 0;
	
	public synchronized void añadir (int dato) {
		
		elementos[fin] = dato;
		
		fin = ( fin + 1) % elementos.length;
		cantidad++;
		notifyAll();
		
	}
	
	public synchronized int extraer() throws InterruptedException {
		while (cantidad == 0) {
			wait();
		}
		
		int dato = elementos[inicio];
		inicio = (inicio + 1) % elementos.length;
		cantidad --;
		return dato;
		
	}
	
	public synchronized int [] getPendientes() {
		int [] pendientes = new int[cantidad];
		for ( int i = 0; i < cantidad; i++) {
			pendientes[i] = elementos[(inicio + i) % elementos.length];
		}
		
		return pendientes;
 	}
 }
