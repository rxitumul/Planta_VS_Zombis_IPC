package com.mycompany.plantasvzzombis.BackEnd.Entidades;

import javax.swing.JLabel;

public abstract class Planta extends Entidad{
    protected int damage;
    protected int cadencia;

    public Planta(int salud, int damage, int cadencia,int hubicacionX, int hubicacionY, JLabel fijura) {

        this.damage=damage;
        this.cadencia=cadencia;
        super(hubicacionX, hubicacionY, fijura,salud);
    }

    public abstract void mecanica();

}
