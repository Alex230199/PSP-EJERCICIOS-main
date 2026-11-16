package actividadesRepasoHilos;

public class Act14_Cola {

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
