package montajeodenador;

public class Almacenamiento {

	static class TareaAlmacenamiento implements Runnable {
        @Override
        public void run() {
            String[] pasos = {
                "Almacenamiento: conectando disco duro...",
                "Almacenamiento: configurando particiones...",
                "Almacenamiento terminado."
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
