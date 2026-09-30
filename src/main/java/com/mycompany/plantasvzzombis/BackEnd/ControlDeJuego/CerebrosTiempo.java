package com.mycompany.plantasvzzombis.BackEnd.ControlDeJuego;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JToggleButton;

import com.mycompany.plantasvzzombis.BackEnd.Entidades.ZombisPadre;
import com.mycompany.plantasvzzombis.FrontEnd.Jardin;

public class CerebrosTiempo extends Thread {
    private int cantidadDeCerebros;
    private int[] mapaCantidad = new int[2];
    private ZombisPadre[] zombisPreferencias;
    private Jardin front;
    protected volatile boolean pausa = false;
    protected volatile boolean detenido = false;

    public CerebrosTiempo(int cantidaddeCerebros, int x, int y, ZombisPadre[] zombisPreferencias,
            JToggleButton[] botones, Jardin front) {
        this.front = front;
        this.cantidadDeCerebros = cantidaddeCerebros;
        mapaCantidad[0] = x;
        mapaCantidad[1] = y;
        this.zombisPreferencias = zombisPreferencias;
        for (int i = 0; i < zombisPreferencias.length; i++) {
            if (zombisPreferencias[i].getCosto() <= cantidadDeCerebros) {
                botones[i].setEnabled(true);
            } else {
                botones[i].setEnabled(false);
            }
        }
    }

    public void sumadorDeCerebros(int suma, JToggleButton[] botones) {
        cantidadDeCerebros += suma;
        for (int i = 0; i < zombisPreferencias.length; i++) {
            if (zombisPreferencias[i].getCosto() <= cantidadDeCerebros) {
                botones[i].setEnabled(true);
            } else {
                botones[i].setEnabled(false);
            }
        }
    }

    @Override
    public void run() {

    }

    public void cordenadasDeCerrebro() {
        JButton cerebro = null;
        Random rand = new Random();
        while (true) {
            if (detenido)
                break;
            if (!pausa) {
                try {
                    Thread.sleep(rand.ints(5, 16).findFirst().getAsInt());
                    int posicionCerebroX = rand.ints(5, mapaCantidad[0] - 5).findFirst().getAsInt();
                    int posicionCerebroY = rand.ints(5, mapaCantidad[1] - 5).findFirst().getAsInt();
                    cerebro = front.agregarcerebro(posicionCerebroX, posicionCerebroY, this);

                    Thread.sleep(rand.ints(5, 16).findFirst().getAsInt());
                    front.eliminadorDeBoton(cerebro);

                } catch (InterruptedException e) {
                    if (cerebro != null) {
                        front.eliminadorDeBoton(cerebro);
                    }
                    break;
                }
            } else {
                /*
                 * metodo de pausa y actualizacion de datos
                 */
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

}
