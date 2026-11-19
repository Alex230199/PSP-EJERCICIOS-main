package actividadesRepasoHilos;

public class Act14_Trabajador implements Runnable {
	
	/*
	 Conceptos: Runnable, synchronized, wait, notifyAll e interrupciones.
Un trabajador recogerá encargos de una cola compartida, en el orden de llegada. Main añadirá cinco 
encargos identificados del 1 al 5 y podrá detener el servicio.
1. Implementa añadir() y extraer() con el mismo monitor. extraer() esperará con while y wait()
cuando la cola esté vacía; añadir() insertará el encargo y avisará con notifyAll().
2. Procesar un encargo consistirá en dormir 300 ms fuera del monitor. Solo se considera completado si 
esa pausa termina normalmente.
3. Main arrancará al trabajador, añadirá los cinco encargos, esperará unos 500 ms y lo interrumpirá. El 
trabajador atenderá la petición antes de recoger otro encargo y también si se interrumpe su espera o 
su pausa.
4. Después de join(), main mostrará tres listas: completados; retirado de la cola pero cancelado antes 
de completarse, si lo hay; y pendientes en la cola. Repite con la cola vacía desde el inicio.
COMPRUEBA
En la primera prueba, los cinco identificadores aparecen una sola vez entre las tres listas. No se exige un 
reparto concreto. En ambas pruebas, el trabajador termina y no queda esperando.
EXPLICA
¿Por qué un encargo retirado de la cola no puede contarse automáticamente como completado?
	 */

	private Act14_Cola cola;
	
	private int[] completados = new int[5];
	private int totalCompletados = 0;
	private int cancelado = -1;
	private boolean hayCancelado = false;
	
	public Act14_Trabajador (Act14_Cola cola) {
		this.cola = cola;
	}
	
	@Override
	public void run() {
		
		try {
			while (true) {
				int encargo = cola.extraer();
				
				try {
					Thread.sleep(300);
					completados[totalCompletados] = encargo;
					totalCompletados++;
					
				} catch (InterruptedException e) {
					cancelado = encargo;
					this.hayCancelado = true;
					Thread.currentThread().interrupt();
					break;
					
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public int[] getCompletados() {
		
		int[] resultado = new int[totalCompletados];
		for (int i = 0; i <totalCompletados; i++) {
			resultado[i] = completados[i];
			
		}
		
		return resultado;
				
	}
	
	public boolean tieneCancelado() {
		return hayCancelado;
		
	}
	
	public int getCancelado() {
		return cancelado;
	}
}
