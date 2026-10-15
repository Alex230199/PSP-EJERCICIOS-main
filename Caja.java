package cajaregistradora;

public class Caja {
    private double total = 0.0;

    // Método sincronizado para asegurar el acceso seguro de varios hilos
    public synchronized void cobrar(double cantidad) {
        total += cantidad;
    }

    public double getTotal() {
        return total;
    }
}


