package clases;
/*
ordene un vector de enteros mediante hilos.
Un max de 8 hilos.
Un vector de 100 posiciones, va a guardar valores de tipo entero.

Los productores van a producir vectores con numeros aleatorios, entre 0 y 100.000.
Los consumidores tienen como entrada el vector desordenado y te da ya la suma de todos los valores
que tiene.
Quiere que haya de los 8 hilos cuatro son productores y 4 son consumidores
y como maximo puede haber en espera 10 vectores pendientes.
Maximo 10 vectores
 */

//Esta clase sirve como punto de sincronizacion y guarda la lista de datos
import java.util.ArrayList;

public class Contenedor {

    private ArrayList<int[]>datos=new ArrayList<>();
    private int MAXIMO_ALCANZADO=10;

    synchronized public void put(int[] valor) {
        datos.add(valor);
    }

    synchronized public int[] get() {
        int[]dato=datos.get(0);
        datos.remove(0);
        return dato;
    }

    synchronized public boolean maximoAlcanzado(){
        return datos.size()>=MAXIMO_ALCANZADO;
    }
    synchronized public boolean listVacia(){
        return datos.isEmpty();
    }

}
