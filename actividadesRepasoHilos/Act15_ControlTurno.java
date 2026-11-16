package actividadesRepasoHilos;

public class Act15_ControlTurno {

	private char turno = 'A';
	private boolean cancelado = false;
	
	public synchronized void imprimirLetra (char letra) throws InterruptedException{
		
		char siguiente = (letra == 'A') ? 'B' : 'A';
		
		if (cancelado) return;
		
		while (!cancelado && turno != letra) {
			wait();
		}
		
		if (cancelado) return;
		
		System.out.println(letra);
		turno =  siguiente;
		notifyAll();
		
	}
	
	public synchronized void marcaCancelado() {
		cancelado = true;
		notifyAll();
		
	}
	
}
