package com.mycompany.plantasvzzombis.BackEnd.Entidades;

import javax.swing.JLabel;

public abstract class Planta extends Entidad{
    protected int salud;
    protected int damage;
    protected int cadencia;

    public Planta(int salud, int damage, int cadencia,int hubicacionX, int hubicacionY, JLabel fijura) {
        super(hubicacionX, hubicacionY, fijura);
        this.salud=salud;
        this.damage=damage;
        this.cadencia=cadencia;
    }

    public abstract void mecanica();

}
