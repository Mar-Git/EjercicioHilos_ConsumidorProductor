package clases;

import java.util.Random;

//va a producir los arrays
public class HiloProductor implements Runnable{

    private Contenedor datos;
    private int[] vector=new int[100];
    int[]dato;
    public HiloProductor(Contenedor datos, String miNombre){
        this.datos =datos;
    }
    @Override
    public void run() {

        while (true) {
            //si ponemos el bloque sincronizado solo va a ser un hilo el que produzca el resto va a estar esperando
            synchronized (datos) {
                dato=producirDatos();
                while (datos.maximoAlcanzado()) {
                    try {
                        this.datos.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                //aqui la logica de mi ejercicio

                //añade los datos a la lista
                datos.put(dato);
                //despertamos a todos los hilos
                datos.notifyAll();
            }

            //este tiene que estar fuera porque no es necesario que este sincronizado, los hilos pueden acceder simultaneamente y producir datos

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
