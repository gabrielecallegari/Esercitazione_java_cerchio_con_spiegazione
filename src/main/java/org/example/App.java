package org.example;

import javax.swing.*;
import java.util.Random;

/**
 *
 *
 */
public class App 
{
    private static Thread th; //dichiarazione thread
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Grafica grafica=new Grafica("Progetto"); //chiama la finestra
                timerNostro(grafica);
                th.start();
            }
        });
    }
    public static void timerNostro(Grafica grafica){
        Random rand=new Random();
        th=new Thread(()->{ //creazione thread
            while(true){ //ciclo infinito
                grafica.setX(rand.nextInt(400)+50); //genera x casuale
                grafica.setY(rand.nextInt(200)+50); //genera y casuale
                grafica.repaint(); //ristampa col punto nuovo
                try {
                    Thread.sleep(1500); //fa dormire il thread per 1 secondo e 5
                } catch (InterruptedException e) {
                    break; //interruzione forzata del thread
                }
            }
        });
    }
}
