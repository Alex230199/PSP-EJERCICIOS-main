package montajeodenador;

public class Main {

	public static void main(String[] args) {
        // 1. Creación de los hilos para cada trabajo independiente
        Thread hiloPlacaBase = new Thread("PlacaBase");
        Thread hiloAlmacenamiento = new Thread("Almacenamiento");
        Thread hiloTarjetaGrafica = new Thread("TarjetaGrafica");

        // 2. Inicio de la ejecución de los tres hilos
        hiloPlacaBase.start();
        hiloAlmacenamiento.start();
        hiloTarjetaGrafica.start();

        try {
            // El hilo principal espera 2 segundos antes de simular la incidencia
            Thread.sleep(2000);
            System.out.println("\n[Sistema] Enviando interrupción al trabajador de la tarjeta gráfica...\n");
            
            // Envío de la interrupción al hilo de la tarjeta gráfica
            hiloTarjetaGrafica.interrupt();

            // 3. Esperar a que los tres trabajadores terminen sus tareas (join)
            hiloPlacaBase.join();
            hiloAlmacenamiento.join();
            hiloTarjetaGrafica.join();

        } catch (InterruptedException e) {
            System.err.println("El hilo principal fue interrumpido: " + e.getMessage());
        }

        // 4. Finalización del montaje
        System.out.println("\nTodos los componentes están preparados. Iniciando montaje final del ordenador...");

        try {
            Thread.sleep(2000); // Espera final de 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ORDENADOR TERMINADO");
    }
}
