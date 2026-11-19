package actividadesRepasoHilos;

public class Act12_Buzon {
	
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
	
	private int numero;
	private boolean lleno = false;
	
	public synchronized void poner(int dato) throws InterruptedException{
		
		while(lleno) {
			wait();
		}
		
		numero = dato;
		lleno = true;
		notifyAll();
	}

	public synchronized int recoger() throws InterruptedException{
		
		while(!lleno) {
			wait();
		}
		lleno =false;
		notifyAll();
		return numero;
	}
}
