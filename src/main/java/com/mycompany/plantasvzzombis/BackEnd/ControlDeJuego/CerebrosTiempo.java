package com.mycompany.plantasvzzombis.BackEnd.ControlDeJuego;

import javax.swing.JToggleButton;

import com.mycompany.plantasvzzombis.BackEnd.Entidades.ZombisPadre;
import com.mycompany.plantasvzzombis.FrontEnd.Jardin;

public class CerebrosTiempo extends Thread {
    private int cantidadDeCerebros;
    private ZombisPadre[] zombisPreferencias;

    public CerebrosTiempo(int cantidaddeCerebros, int x, int y, ZombisPadre[] zombisPreferencias,
            JToggleButton[] botones, Jardin front) {
        this.cantidadDeCerebros = cantidaddeCerebros;
       
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
    public int getCantidadDeCerebros() {
        return cantidadDeCerebros;
    }
}