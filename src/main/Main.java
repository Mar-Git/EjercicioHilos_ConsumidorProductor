package main;

import clases.Contenedor;
import clases.HiloConsumidor;
import clases.HiloProductor;

public class Main {

    public static void main(String[] args) {


        Contenedor almacen = new Contenedor();
        Thread hprod1 = new Thread(new HiloProductor(almacen, "P1"));
        Thread hprod2 = new Thread(new HiloProductor(almacen, "P2"));
        Thread hprod3 = new Thread(new HiloProductor(almacen, "P3"));
        Thread hprod4 = new Thread(new HiloProductor(almacen, "P4"));
        Thread hcons1 = new Thread(new HiloConsumidor(almacen, "C1"));
        Thread hcons2 = new Thread(new HiloConsumidor(almacen, "C2"));
        Thread hcons3 = new Thread(new HiloConsumidor(almacen, "C3"));
        Thread hcons4 = new Thread(new HiloConsumidor(almacen, "C4"));
        hprod1.start();
        hprod2.start();
        hprod3.start();
        hprod4.start();
        hcons1.start();
        hcons2.start();
        hcons3.start();
        hcons4.start();
    }
}
