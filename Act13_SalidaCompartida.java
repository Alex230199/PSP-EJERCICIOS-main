package actividadesRepasoHilos;

public class Act13_SalidaCompartida {

	private boolean salida = false;
	
	
	public synchronized void esperarSalida() throws InterruptedException{
		while(!salida) {
			wait();
		}
	}
	
	public synchronized void darSalida() {
		System.out.println("salida");
		salida = true;
		notifyAll();
	}
}
