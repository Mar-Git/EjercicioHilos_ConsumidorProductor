package clases;
//va a sumar los arrays

public class HiloConsumidor implements Runnable{

    private final Contenedor DATOS;

    public HiloConsumidor(Contenedor datos, String miNombre){
        this.DATOS=datos;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (DATOS) {
                while (DATOS.listVacia()) {
                    try {
                        this.DATOS.wait();
                    } catch (InterruptedException ex) {
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
