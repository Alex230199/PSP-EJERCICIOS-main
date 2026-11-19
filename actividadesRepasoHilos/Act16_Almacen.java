package actividadesRepasoHilos;

public class Act16_Almacen {
	
	/*
	 Conceptos: Runnable, synchronized, wait, notifyAll e interrupciones.
Dos productores introducirán datos en un almacén de capacidad cinco. Tres consumidores los 
retirarán. Cada productor intentará introducir diez datos con identificadores distintos, por 
ejemplo P1-1 y P2-1.
1. Protege el almacén con un único monitor. Para almacenar, espera mientras esté lleno. Para 
retirar, espera mientras esté vacío y todavía queden productores trabajando. Usa while y 
wait().
2. Guarda un contador de productores activos, inicialmente 2. Cada productor lo reducirá 
exactamente una vez al terminar, también si se interrumpe. Comunica ese cambio y los 
cambios de ocupación con notifyAll().
3. Cuando el almacén esté vacío y no queden productores, retirar() devolverá una señal 
de fin, como null, para que los consumidores terminen. Los datos normales no podrán ser 
null.
4. Para esta actividad, un dato cuenta como consumido en el momento de retirarlo. Registra 
su identificador y la retirada dentro de la misma sección sincronizada. Cualquier pausa 
posterior simula trabajo y se hace fuera del monitor.
5. Prueba el funcionamiento normal, capacidad uno y consumidores lentos. Después prueba 
cancelación: main interrumpirá a todos y hará join() a todos. Los bucles deben atender 
la interrupción.
COMPRUEBA
Sin cancelación se almacenan y retiran veinte identificadores, sin duplicados. La ocupación 
nunca supera la capacidad. Tras cancelar, los datos que llegaron a almacenarse deben 
coincidir exactamente con los retirados más los que siguen dentro; los que no llegaron a 
entrar se cuentan aparte.
EXPLICA
¿Por qué el último productor tiene que avisar aunque no haya añadido un dato nuevo?
	 */

	private String[] datos = new String[5];
	private int cuenta = 0;
	private int productoresActivos = 2;
	
	public synchronized void almacenar(String dato) throws InterruptedException{
		
		while(cuenta == 5) {
			wait();
		}
		
		datos[cuenta] = dato;
		cuenta++;
		notifyAll();
		
	}
	
	public synchronized String retirar () throws InterruptedException{
		
		while (cuenta == 0 && productoresActivos > 0) {
			wait();
		}
		
		if (cuenta == 0 && productoresActivos == 0) {
			return null;
			
		}
		
		String dato = datos[0];
		
		for(int i = 0; i < cuenta - 1; i++) {
			datos[i] = datos [i + 1];
		}
		
		datos[cuenta - 1] = null;
		cuenta--;
		
		notifyAll();
		return dato;
	}
	
	public synchronized void terminarProductor() {
		productoresActivos --;
		notifyAll();
	}
}
