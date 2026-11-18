package actividadesRepasoHilos;

public class Act20_BaulCantidades {

	private int camarasDisponibles;
	private int microfonosDisponibles;
	
	public Act20_BaulCantidades() {
		
		this.camarasDisponibles = 2;
		this.microfonosDisponibles = 3;
	}
	
	public synchronized void reservar() throws InterruptedException{
		
		while(camarasDisponibles == 0 || microfonosDisponibles == 0) {
			wait();
		}
		
		camarasDisponibles--;
		microfonosDisponibles--;
		
	}
	
	public synchronized void devolver() {
		
		camarasDisponibles++;
		microfonosDisponibles++;
		notifyAll();
	}

	public int getCamarasDisponibles() {
		return camarasDisponibles;
	}

	public int getMicrofonosDisponibles() {
		return microfonosDisponibles;
	}
	
	
}
