
package actividadesRepasoHilos;

import java.util.Random;

public class Act17_TrabajadorTransferencias implements Runnable{

	private Act17_Cuenta[] cuentas;
	private Act17_Banco banco;
	
	public Act17_TrabajadorTransferencias (Act17_Cuenta[] cuentas, Act17_Banco banco) {
		this.banco = banco;
		this.cuentas = cuentas;
		
	}
	
	@Override
	
	public void run() {
		
		Random random = new Random (42);
		
		for (int i = 0; i < 1000; i++) {
			
			if (Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().getName() + " interrumpido. Saliendo...");
				break;
			}
			
			int indiceOrigen = random.nextInt (cuentas.length);
			int indiceDestino;
			
			do {
				indiceDestino = random.nextInt(cuentas.length);
				
			} while (indiceDestino == indiceOrigen);
			
			int importe = random.nextInt(50) + 1;
			
			banco.realizarTransferencia(cuentas[ indiceOrigen], cuentas[indiceDestino], importe);
		}
	}
	
}
