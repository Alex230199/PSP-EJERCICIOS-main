package actividadesRepasoHilos;

import java.util.ArrayList;
import java.util.List;

public class Main_Entrada {
	
	public static void main (String [] args) {
		
		
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
		
		int totalEntradas = 20;
		Act11_Entradas inventario = new Act11_Entradas(totalEntradas);
		
		Act11_Vendedor ven1 = new Act11_Vendedor(inventario);
		Act11_Vendedor ven2 = new Act11_Vendedor(inventario);
		Act11_Vendedor ven3 = new Act11_Vendedor(inventario);
		
		Thread h1 = new Thread(ven1, "Vendedor1");
		Thread h2 = new Thread(ven2, "Vendedor1");
		Thread h3 = new Thread(ven3, "Vendedor1");
		
		h1.start();
		h2.start();
		h3.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<Integer> entradasVendidasTotal = new ArrayList<>();
		
		
		imprimirventasVendedor(h1.getName(), ven1.getEntradasVendidas(), entradasVendidasTotal);
		imprimirventasVendedor(h2.getName(), ven2.getEntradasVendidas(), entradasVendidasTotal);
		imprimirventasVendedor(h3.getName(), ven3.getEntradasVendidas(), entradasVendidasTotal);
		
		
		System.out.println("Total de entradas vendida: " + entradasVendidasTotal.size());
		System.out.println("Listado total vendido: " + entradasVendidasTotal);
		
	}
		
		private static void imprimirventasVendedor (String nombre, List<Integer> vendidas, List<Integer> global ) {
			System.out.println( nombre + " vendió " + vendidas.size() + " entradas" + vendidas);
			global.addAll(vendidas);
		
		
		
	}

}
