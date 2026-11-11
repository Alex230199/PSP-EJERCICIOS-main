package actividadesRepasoHilos;

import java.util.ArrayList;
import java.util.List;

public class Act11_Vendedor implements Runnable {

	private Act11_Entradas inventario;
	private List<Integer> entradasVendidas;
	
	public Act11_Vendedor (Act11_Entradas inventario) {
		
		this.inventario = inventario;
		this.entradasVendidas = new ArrayList<>();
		
	}
	
	public List<Integer> getEntradasVendidas(){
		
		return entradasVendidas;
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			int entrada = inventario.vender();
			if (entrada == -1) {
				break;
			}
			
			entradasVendidas.add(entrada);
		}
		
		//Pausa opcional fuer del synchronized
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
	}
}
