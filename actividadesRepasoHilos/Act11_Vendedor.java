package actividadesRepasoHilos;

import java.util.ArrayList;
import java.util.List;

public class Act11_Vendedor implements Runnable {
	
	
	/*
	 Conceptos: Runnable, métodos de instancia y synchronized.
Tres vendedores, cada uno en su propio hilo, venderán veinte entradas numeradas del 1 al 20. Todos 
usarán un único objeto compartido InventarioEntradas.
1. Crea vender(): devolverá el número de una entrada disponible o -1 cuando se hayan agotado. 
Comprueba y actualiza las existencias en una sola sección sincronizada.
2. Cada vendedor llamará a vender() hasta recibir -1. Guardará los números vendidos en una lista 
propia. Si añades pausas, colócalas fuera de synchronized.
3. Después de todos los join(), main reunirá las listas y mostrará las entradas vendidas por cada hilo y el 
total.
COMPRUEBA
Con veinte entradas se venden exactamente los números del 1 al 20, sin repetidos. También deben 
terminar las pruebas con cero entradas y con una entrada. No se exige repartir las ventas por igual.
EXPLICA
¿Qué error podría ocurrir si comprobar las existencias y descontar una entrada fueran operaciones 
separadas sin protección conjunta?

	 */

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
