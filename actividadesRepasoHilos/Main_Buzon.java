package actividadesRepasoHilos;

public class Main_Buzon {
	
	/*
	 Conceptos: Recurso compartido, synchronized, wait, notifyAll e interrupciones.
Un productor enviará los números del 1 al 10 y un consumidor los recogerá. El buzón compartido solo 
puede contener un número pendiente.
1. Define poner(int dato) y recoger(), que devolverá un int. El productor esperará mientras el 
buzón esté lleno y el consumidor mientras esté vacío.
2. Usa el mismo monitor para proteger el número y el estado del buzón. Comprueba las condiciones con 
while y llama a notifyAll() tras depositar o retirar un dato.
3. En la prueba normal, cada participante hará diez operaciones. Main hará join() a ambos. Prueba 
añadiendo pausas fuera del monitor primero al productor y después al consumidor.
4. En una ejecución aparte, main interrumpirá a ambos. Si una espera lanza InterruptedException, 
deja que llegue a run(), restaura allí la marca y termina.
COMPRUEBA
En las pruebas normales se reciben los números del 1 al 10 en orden. En la cancelación pueden recibirse 
menos, pero los dos hilos deben terminar.
EXPLICA
¿Por qué hay que comprobar de nuevo si el buzón está lleno o vacío después de despertar?
	 */

	public static void main (String [] args) {
		
		Act12_Buzon buzon = new Act12_Buzon();
		
		Thread hProductor = new Thread(new Act12_Productor(buzon));
		Thread hConsumidor = new Thread(new Act12_Consumidor(buzon));
		
		hProductor.start();
		hConsumidor.start();
		
		/* COMPROBACION DE CANCELACIÓN (PUNTO 4)
		try {
			Thread.sleep(50);
			hProductor.interrupt();
			hConsumidor.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		try {
			hProductor.join();
			hConsumidor.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Fin del programa");
		
		
	}
}
