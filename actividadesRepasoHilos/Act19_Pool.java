package actividadesRepasoHilos;

public class Act19_Pool {

	private Act19_Tarea[] cola =new Act19_Tarea[4];
	
	private int inicio = 0;
	
	private int fin = 0;
	
	private int cuenta = 0;
	
	private boolean cerrado = false;
	
	
	public synchronized boolean enviar(Act19_Tarea tarea) throws InterruptedException{
		
		while(cuenta == cola.length && !cerrado) {
			wait();
		}
		
		if (cerrado) {
			return false;
		}
		
		cola[fin] = tarea;
		
		fin = (fin + 1) % cola.length;
		
		cuenta++;
		
		notifyAll();
		
		return true;
	}
	
	public synchronized Act19_Tarea extraer() throws InterruptedException{
		
		while (cuenta == 0 && !cerrado) {
			
			wait();
		}
		
		if (cuenta == 0 && cerrado) {
			return null;
			
		}
		
		Act19_Tarea t = cola[inicio];
		
		cola[inicio] = null;
		
		inicio = (inicio + 1) % cola.length;
		
		cuenta--;
		
		notifyAll();
		
		return t;
	}
	
	public synchronized void cerrar() {
		
		cerrado = true;
		notifyAll();
		
	}
	
	public synchronized Act19_Tarea[] cancelarAhora() {
		
		cerrado = true;
		Act19_Tarea[] pendientes = new Act19_Tarea[cuenta];
		
		for (int i = 0; i < cuenta; i++) {
			
			pendientes[i] = cola[(inicio + i) % cola.length];
		}
		
		cuenta = 0;
		
		inicio = 0;
		
		fin = 0;
		
		notifyAll();
		
		return pendientes;
	}
 }
