package montajeodenador;

public class PlacaBase {
	
	static class TareaPlacaBase implements Runnable {
        @Override
        public void run() {
            String[] pasos = {
                "Placa base: colocando procesador...",
                "Placa base: instalando memoria RAM...",
                "Placa base: conectando alimentación...",
                "Placa base terminada."
            };
            
            for (String paso : pasos) {
                System.out.println(paso);
                try {
                    Thread.sleep(1000); // Pausa de 1 segundo entre acciones
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
