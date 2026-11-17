package actividadesRepasoHilos;

public class Act6_Contador_Synchronized {
	
	/*public class Contador {
	    private int valor = 0; 

	    
	    public synchronized void incrementar() {
	        valor++;
	    }

	    
	    public synchronized int getValor() {
	        return valor;
	    }
	}*/

	private int valor = 0;
	
	public void incrementar() {
		
		synchronized (this) {
			valor++;
		}
	}
	
	public int getValor() {
		
		synchronized (this) {
			return valor;
		}
	}
}
