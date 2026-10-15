package cajaregistradora;

import java.util.Random;

public class Empleado {
	
	private Caja caja;
    private String nombre;

    public Empleado(Caja caja, String nombre) {
        this.caja = caja;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 1; i <= 5; i++) {
            // Genera un importe aleatorio entre 5.0 y 100.0 €
            double importe = 5.0 + (100.0 - 5.0) * random.nextDouble();
            // Redondeamos a 2 decimales
            importe = Math.round(importe * 100.0) / 100.0;

            // Cobra la cantidad en la caja compartida
            caja.cobrar(importe);

            // Muestra por pantalla el cobro y el total acumulado
            System.out.println("Empleado " + nombre + " cobró " + importe + " €. Total en caja: " + caja.getTotal() + " €");

            // Pausa entre clientes simulando el tiempo de cobro
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
