package actividadesRepasoHilos.Act9;

public class Act9_PuertaNotify {
	
	/*
	 Concepto nuevo: Notificación mediante notify.
Modifica el ejercicio 8 para que un único hilo espere sin comprobar la puerta cada 200 ms. El hilo que abre 
se encargará de avisarle.
1. Sustituye wait(200) por wait(). Conserva el while que comprueba si la puerta sigue cerrada.
2. El hilo que abre debe cambiar abierta a true y llamar a notify() sobre la misma puerta, dentro del 
mismo bloque synchronized.
3. Prueba con ambos hilos arrancados. Haz además otra ejecución en la que arranques primero al que 
abre, esperes a que termine con join() y después arranques al que quiere pasar.
4. Mantén la gestión de interrupciones del ejercicio 8 y espera a todos los hilos antes de terminar main.
COMPRUEBA
En ambas pruebas aparece «Paso permitido» y el programa termina. En la segunda, el receptor encuentra 
la puerta abierta y no debe quedarse esperando un aviso pasado.
EXPLICA
¿Por qué sigue siendo necesario guardar abierta aunque se utilice notify()?

	 */

	boolean abierta = false;
	
}
