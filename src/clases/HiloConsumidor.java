package clases;
//va a sumar los arrays

public class HiloConsumidor implements Runnable{

    private final Contenedor DATOS;
    private final String miNombre;

    public HiloConsumidor(Contenedor datos, String miNombre){
        this.DATOS=datos;
        this.miNombre=miNombre;
    }

    @Override
    public void run() {
        boolean interrumpir=false;
        while(!Thread.currentThread().isInterrupted() && !interrumpir) {
            synchronized (DATOS) {
                while (DATOS.listVacia() && !Thread.currentThread().isInterrupted()) {
                    try {
                        this.DATOS.wait();
                    } catch (InterruptedException ex) {
                        interrumpir = true;
                    }
                }
                //aqui la logica de mi ejercicio
                consumirDatos(DATOS.get());
                DATOS.notifyAll();
            }
        }
    }
    private void consumirDatos(int[] vector){
        //mostrar en pantalla la suma de los arrays
        int sumaTotal=0;
        for (int i = 0; i < 100; i++) {
            sumaTotal+=vector[i];
        }
        System.out.println("El total del array es: "+sumaTotal);

    }
}
/*
package principal;

public class Consumidor implements Runnable {
    private final Contenedor datos;
    private final int númeroConsumidor;
    private boolean interrumpir = false;
    private int[] dato = null;

    public Consumidor(Contenedor datos, int númeroConsumidor) {
        this.númeroConsumidor = númeroConsumidor;
        this.datos = datos;
    }

    @Override
    public void run() {
        while (!interrupciónLanzada()) {
            obtenerDato();
            if (!interrupciónLanzada())
                consumirDato(dato);
        }
        System.out.printf("Hilo consumidor %d interrumpido", númeroConsumidor);
    }

    private void obtenerDato() {
        synchronized (datos) {
            while (datos.vacío() && !interrupciónLanzada()) {
                esperar();
            }
            if (!interrupciónLanzada())
                dato = datos.get();
            datos.notifyAll();
        }
    }

    private void esperar() {
        try {
            datos.wait();
        } catch (InterruptedException ex) {
            interrumpir = true;
        }
    }

    private boolean interrupciónLanzada() {
        return !Thread.currentThread().isInterrupted()
                && !interrumpir;
    }

    private void consumirDato(int[] dato) {
        int suma = 0;
        for (int i = 0; i < dato.length; i++)
            suma += dato[i];
        System.out.println(suma);
    }
}
 */
