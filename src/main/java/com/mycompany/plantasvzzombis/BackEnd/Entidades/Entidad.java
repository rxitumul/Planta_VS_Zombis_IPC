package com.mycompany.plantasvzzombis.BackEnd.Entidades;

import javax.swing.JLabel;

public class Entidad {
    protected int hubicacionX;
    protected int hubicacionY;
    protected JLabel fijura;
    protected int salud;

    public Entidad(int hubicacionX, int hubicacionY, JLabel fijura, int salud) {
        this.hubicacionX = hubicacionX;
        this.hubicacionY = hubicacionY;
        this.fijura = fijura;
        this.salud = salud;
    }
    

}
