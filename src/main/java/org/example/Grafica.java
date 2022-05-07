package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Grafica extends JFrame {
    //creazione punto private per usare setter e getter nel main
    private int x,y;
    public boolean preso=false;
    public int getXpunto() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getYpunto() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    Grafica(){}
    Grafica(String title){ //serve per creare la finestra
        this.setSize(500,300); //setta dimensioni finestra
        this.setLocationRelativeTo(null); //fa apparire la finestra al centro dello schermo (N.B: farlo dopo set size)
        this.setVisible(true); //fa vedere la finestra
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fa terminare tutto quando premo la x della finestra

        this.addMouseListener(new MouseListener() { //aggiunge il listener del mouse
            @Override
            public void mouseClicked(MouseEvent e) {
                //e perché è l'evento del click del mouse
                int x=e.getX();
                int y=e.getY();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    public void paint(Graphics g){ //serve per disegnare nella finestra
        super.paint(g); //rimuove i vecchi pallini
        setColorCircle(g,preso);
        g.fillOval(this.getXpunto(),this.getYpunto(),50,50); //colora tutto l'interno  della circonferenza
        preso=false;
        //g.drawOval(); //colora solo la circonferenza
    }

    public void setColorCircle(Graphics g, boolean preso){
        //settaggio del colore del cerchio
        if( preso==true){
            g.setColor(Color.green); //se preso diventa verde
        }
        else{
            g.setColor(Color.red); //se non preso diventa rosso
        }
    }
}
