package actividadesRepasoHilos;

public class Act16_Almacen {

	private String[] datos = new String[5];
	private int cuenta = 0;
	private int productoresActivos = 2;
	
	public synchronized void almacenar(String dato) throws InterruptedException{
		
		while(cuenta == 5) {
			wait();
		}
		
		datos[cuenta] = dato;
		cuenta++;
		notifyAll();
		
	}
	
	public synchronized String retirar () throws InterruptedException{
		
		while (cuenta == 0 && productoresActivos > 0) {
			wait();
		}
		
		if (cuenta == 0 && productoresActivos == 0) {
			return null;
			
		}
		
		String dato = datos[0];
		
		for(int i = 0; i < cuenta - 1; i++) {
			datos[i] = datos [i + 1];
		}
		
		datos[cuenta - 1] = null;
		cuenta--;
		
		notifyAll();
		return dato;
	}
	
	public synchronized void terminarProductor() {
		productoresActivos --;
		notifyAll();
	}
}
