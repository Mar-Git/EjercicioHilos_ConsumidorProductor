package clases;

import java.util.Random;

//va a producir los arrays
public class HiloProductor implements Runnable{

    private final Contenedor DATOS;
    private int[] vector=new int[100];

    public HiloProductor(Contenedor datos){
        this.DATOS=datos;
    }
    @Override
    public void run() {

        while (true) {
            synchronized (DATOS) {
                while (DATOS.maximoAlcanzado()) {
                    try {
                        this.DATOS.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                DATOS.notifyAll();
                //aqui la logica de mi ejercicio
                vector=producirDatos();
            }
        }
    }
    private int[] producirDatos(){
        Random random=new Random();
        for(int i=0; i<100 ; i++){
            vector[i]=random.nextInt(10001);
        }
        return vector;
    }
}
