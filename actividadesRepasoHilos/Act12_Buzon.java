package actividadesRepasoHilos;

public class Act12_Buzon {
	
	private int numero;
	private boolean lleno = false;
	
	public synchronized void poner(int dato) throws InterruptedException{
		
		while(lleno) {
			wait();
		}
		
		numero = dato;
		lleno = true;
		notifyAll();
	}

	public synchronized int recoger() throws InterruptedException{
		
		while(!lleno) {
			wait();
		}
		lleno =false;
		notifyAll();
		return numero;
	}
}
