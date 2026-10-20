package bocadillo;

public class Maquinabocadillo {

	public boolean hayBocadillo = false;
	
	public synchronized void preparar(int cantidadBocadillo) {
		
		while(hayBocadillo) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		hayBocadillo = true;
		System.out.println("el bocadillo..." + cantidadBocadillo + "...se ha preparado");
		notify();
		
	}
	
	public synchronized void consumir(int cantidadBocadillo) {
		while (!hayBocadillo) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		hayBocadillo = false;
		System.out.println("el bocadillo..." + cantidadBocadillo + "...se ha consumido");
		notify();
		
		}
	}

