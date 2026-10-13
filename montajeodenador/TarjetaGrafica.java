package montajeodenador;

public class TarjetaGrafica {

	static class TareaTarjetaGrafica implements Runnable {
        @Override
        public void run() {
            String[] pasos = {
                "Tarjeta gráfica: insertando en ranura PCIe...",
                "Tarjeta gráfica: conectando cables de corriente...",
                "Tarjeta gráfica: instalando drivers de prueba...",
                "Tarjeta gráfica terminada."
            };
            
            for (int i = 0; i < pasos.length; i++) {
                System.out.println(pasos[i]);
                try {
                    Thread.sleep(1000); // Pausa de 1 segundo entre acciones
                } catch (InterruptedException e) {
                    // Si recibe una interrupción durante el sleep
                    System.out.println(">> [Tarjeta Gráfica] ¡Problema detectado! Incidencia recibida.");
                    System.out.println(">> [Tarjeta Gráfica] Solucionando la incidencia (revisando ranura y conexiones)...");
                    
                    try {
                        Thread.sleep(1000); // Simula el tiempo que toma resolver el problema
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    
                    // La interrupción no finaliza el hilo; este continúa con el bucle restante
                }
            }
        }
    }
}

