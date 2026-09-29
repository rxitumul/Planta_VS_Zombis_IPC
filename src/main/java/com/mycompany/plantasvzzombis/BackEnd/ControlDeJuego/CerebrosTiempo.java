package com.mycompany.plantasvzzombis.BackEnd.ControlDeJuego;

import javax.swing.JToggleButton;

import com.mycompany.plantasvzzombis.BackEnd.Entidades.ZombisPadre;

public class CerebrosTiempo extends Thread {
    private int cantidadDeCerebros;
    private int[] mapaCantidad = new int[2];
    private ZombisPadre[] zombisPreferencias;

    public CerebrosTiempo(int cantidaddeCerebros, int x, int y, ZombisPadre[] zombisPreferencias,
            JToggleButton[] botones) {
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

}
