package cajaregistradora;

public class Main {
	public static void main(String[] args) {
        // 1. Instancia única de la caja registradora compartida
        Caja caja = new Caja();

        // 2. Creación e inicio de los hilos de los empleados
        Thread hilo1 = new Thread(new Empleado(caja, "Ana"));
        Thread hilo2 = new Thread(new Empleado(caja, "Luis"));
        Thread hilo3 = new Thread(new Empleado(caja, "María"));

        hilo1.start();
        hilo2.start();
        hilo3.start();

        // 3. Esperar a que todos los hilos terminen sus tareas con join()
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 4. Mostrar el total final
        System.out.println("\n-------------------------------------------");
        System.out.println("TOTAL FINAL EN CAJA: " + caja.getTotal() + " €");
        System.out.println("-------------------------------------------");
    }
}
