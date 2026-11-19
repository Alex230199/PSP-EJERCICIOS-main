package actividadesRepasoHilos;

public class Act16_Productor implements Runnable {
	
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

	private int id;
	private Act16_Almacen almacen;
	
	public Act16_Productor (int id, Act16_Almacen almacen) {
		
		this.id = id;
		this.almacen = almacen;
		
	}
	
	@Override
	public void run() {
		
		try {
			for (int i = 1; i <= 10; i++) {
				
				String dato = "P " + id + "-" + i;
				almacen.almacenar(dato);
				System.out.println("PRODUCTOR " + id + "almacena: " + dato);
			}
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			
		} finally {
			almacen.terminarProductor();
		}
	}
}
