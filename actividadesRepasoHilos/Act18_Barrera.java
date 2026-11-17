package actividadesRepasoHilos;

public class Act18_Barrera {

	private int llegada = 0;
	private int generacion = 0;
	private boolean cancelada = false;
	private int totalTrabajadores;
	
	public Act18_Barrera (int totalTrabajadores) {
		
		this.totalTrabajadores = totalTrabajadores;
		
	}
	
	public synchronized boolean esperar() throws InterruptedException{
		
		int miGeneracion = generacion;
		llegada++;
		
		if (llegada == totalTrabajadores) {
			llegada = 0;
			generacion++;
			notifyAll();
			
			
			return true;
		}
		
		while (generacion == miGeneracion && !cancelada) {
			wait();
		}
		
		if (cancelada) {
			return false;
		}
		
		return true;
	}
	
	public synchronized void cancelar() {
		cancelada = true;
		notifyAll();
	}
	
	public synchronized boolean estaCancelada() {
		return cancelada;
	}
}
