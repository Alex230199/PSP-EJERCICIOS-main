package montajeordenadorcorreccion;

public class PlacaBase extends Thread{
	public void run() {
		
		for (int i = 0; i < 3; i++) {
			
			switch(i) {
			
			case 0:
				System.out.println("placa base colocando procesador");
				break;
				
			case 1:
				System.out.println("placa base colocando procesador");
				break;
				
			case 2:
				System.out.println("instalando memoria");
				break;
				
			case 3:
				System.out.println("placa base terminada");
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
			
			
		}
	}
}
