package ejemploSincronizacion;

public class EjemploSincronizacion {
	
	    static class Contador {
	        int valor = 0;
	        // SIN sincronizar
	        public void incrementar() {
	            int temporal = valor;
	            pausa();
	            valor = temporal + 1;
	        }
	        // CON sincronizar
	        public synchronized void incrementarSeguro() {
	            int temporal = valor;
	            pausa();
	            valor = temporal + 1;
	        }
	        private void pausa() {
	            try {
	                Thread.sleep(2);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }
	    public static void main(String[] args) throws InterruptedException {
	        probar(false);
	        probar(true);
	    }
	    static void probar(boolean sincronizado) throws InterruptedException {
	        Contador contador = new Contador();
	        Thread[] hilos = new Thread[10];
	        for (int i = 0; i < 10; i++) {
	            hilos[i] = new Thread(() -> {
	                for (int j = 0; j < 100; j++) {
	                    if (sincronizado) {
	                        contador.incrementarSeguro();
	                    } else {
	                        contador.incrementar();
	                    }
	                }
	            });
	            hilos[i].start();
	        }
	        for (Thread hilo : hilos) {
	            hilo.join();
	        }
	        System.out.println(
	            (sincronizado ? "CON" : "SIN") +
	            " sincronizar: " + contador.valor
	        );
	    }
	}

