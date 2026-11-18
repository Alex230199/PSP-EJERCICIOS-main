package actividadesRepasoHilos;

public class Main_SalayEquipo {

	public static void main (String [] args) throws InterruptedException {
		
		//Prueba 1
		
		Act20_BaulCantidades cosasPrueba1 = new Act20_BaulCantidades();
		Thread[] equipos1 = new Thread[5];
		
		for ( int i = 0; i < 5; i++) {
			equipos1[i] = new Thread(new Act20_Equipo ("equipo " + (i + 1), cosasPrueba1));
			equipos1[i].start();
		}
		
		for (int i = 0; i < 5; i++) {
			equipos1[i].join();
		}
 		
		
		System.out.println("FIN DE LA PRUEBA 1");
		
		//Prueba 2
		
		Act20_BaulCantidades cosasPrueba2 = new Act20_BaulCantidades();
		Thread[] equipos2 = new Thread[5];
		
		
		for (int i = 0; i < 5; i++) {
			equipos2[i] = new Thread(new Act20_Equipo ("equipo " + (i + 1), cosasPrueba2));
			equipos2[i].start();
			
		}
		
		Thread.sleep(500);
		
		System.out.println("aqui se para este hilo en la prueba 2");
		
		for (int i = 0; i < 5; i++) {
			equipos2[i].join();
			
			
		}
		
		System.out.println("Fin de la prueba 2 y FIN DEL PROGRAMA!!");
	}
}
