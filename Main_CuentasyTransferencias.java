package actividadesRepasoHilos;

public class Main_CuentasyTransferencias {

	public static void main (String [] args)throws InterruptedException {
		
		Act17_Cuenta[] cuentas = {
				
				new Act17_Cuenta (1, 1000),
				new Act17_Cuenta (2, 1000),
				new Act17_Cuenta (3, 1000)
				
		};
		
		Act17_Banco banco = new Act17_Banco();
		
		Thread h1 = new Thread (new Act17_TrabajadorTransferencias(cuentas, banco),"Hilo 1" );
		Thread h2 = new Thread (new Act17_TrabajadorTransferencias(cuentas, banco),"Hilo 2" );
		Thread h3 = new Thread (new Act17_TrabajadorTransferencias(cuentas, banco),"Hilo 3" );
		
		h1.start();
		h2.start();
		h3.start();
		
		// --- PRUEBA DE CANCELACIÓN (Opcional) ---
        // Si quieres probar la interrupción en caliente, descomenta las siguientes líneas:
        /*
        Thread.sleep(5); // Dejar trabajar un instante
        h1.interrupt();
        h2.interrupt();
        h3.interrupt();
        */
		
		h1.join();
        h2.join();
        h3.join();
        
        System.out.println("\n=== BALANCE FINAL ===" );
        
        int sumaTotal = 0;
        for (Act17_Cuenta c : cuentas) {
        	System.out.println("Cuenta " + c.getId() + ": " + c.getSaldo() + " unidades");
        	sumaTotal += c.getSaldo();
        	
        }
        
        System.out.println("Suma total de saldos: " + sumaTotal);
        
        banco.mostrarEstadisticas();
	}
}
