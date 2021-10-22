package clases;
//va a sumar los arrays

public class HiloConsumidor implements Runnable{

    private final Contenedor DATOS;

    public HiloConsumidor(Contenedor datos){
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
    }
}
