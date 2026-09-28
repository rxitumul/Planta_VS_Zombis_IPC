package com.mycompany.plantasvzzombis.BackEnd.Entidades;

import javax.swing.JLabel;

public class Entidad {
    protected int hubicacionX;
    protected int hubicacionY;
    protected JLabel fijura;

    public Entidad(int hubicacionX, int hubicacionY, JLabel fijura) {
        this.hubicacionX = hubicacionX;
        this.hubicacionY = hubicacionY;
        this.fijura = fijura;
    }

}
