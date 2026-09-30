package com.mycompany.plantasvzzombis.BackEnd.ControlDeJuego;

import java.util.Random;

import javax.swing.JButton;

import com.mycompany.plantasvzzombis.FrontEnd.Jardin;

public class HiloDeCerbros extends Thread {

    private int[] mapaCantidad = new int[2];
    private Jardin front;
    protected volatile boolean pausa = false;
    protected volatile boolean detenido = false;

    public HiloDeCerbros(Jardin front, int x, int y) {
        this.front = front;
        mapaCantidad[0] = x;
        mapaCantidad[1] = y;
    }

    @Override
    public void run() {
        cordenadasDeCerrebro();
    }

    public void cordenadasDeCerrebro() {
        JButton cerebro = null;
        Random rand = new Random();
        while (true) {
            if (detenido)
                break;
            if (!pausa) {
                try {
                    int tiempoEspera = rand.nextInt(11001) + 5000;
                    Thread.sleep(tiempoEspera);

                    int anchoCerebro = 50;
                    int altoCerebro = 50;

                    int limiteX = mapaCantidad[0] - anchoCerebro;
                    int limiteY = mapaCantidad[1] - altoCerebro;

                    int minX = Math.min(5, Math.max(0, limiteX));
                    int minY = Math.min(5, Math.max(0, limiteY));

                    int posicionCerebroX;
                    if (limiteX > minX) {
                        posicionCerebroX = minX + rand.nextInt(limiteX - minX + 1);
                    } else {
                        posicionCerebroX = minX;
                    }
                    int posicionCerebroY;

                    if (limiteY > minY) {
                        posicionCerebroY = minY + rand.nextInt(limiteY - minY + 1);
                    } else {
                        posicionCerebroY = minY;
                    }
                    
                    cerebro = front.agregarcerebro(posicionCerebroX, posicionCerebroY, this);
                    Thread.sleep(5000);
                    front.eliminadorDeBoton(cerebro);
                    cerebro = null;

                } catch (InterruptedException e) {
                    if (cerebro != null) {
                        front.eliminadorDeBoton(cerebro);
                        cerebro = null;
                    }
                    if (detenido) {
                        break;
                    }
                }
            } else {
                /*
                 * metodo de pausa y actualizacion de datos
                 */
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    if (detenido) {
                        break;
                    }
                }
            }
        }
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public void setDetenido(boolean detenido) {
        this.detenido = detenido;
        this.interrupt();
    }

}
