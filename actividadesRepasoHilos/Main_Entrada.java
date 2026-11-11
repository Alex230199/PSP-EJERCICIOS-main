package actividadesRepasoHilos;

import java.util.ArrayList;
import java.util.List;

public class Main_Entrada {
	
	public static void main (String [] args) {
		
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
