package com.mycompany.plantasvzzombis.BackEnd.Entidades;

import javax.swing.JLabel;

public class ZombisPadre extends Entidad{
  protected int damage;
    protected int costo;
    protected double velocidadMod;

    public ZombisPadre(int hubicacionX, int hubicacionY, JLabel fijura, int salud, int damage, int costo,
            double velocidadMod) {
        super(hubicacionX, hubicacionY, fijura, salud);
        this.damage = damage;
        this.costo = costo;
        this.velocidadMod = velocidadMod;
        // TODO Auto-generated constructor stub
    }

    public int getCosto() {
        return costo;
    }

    public String getNombre() {
return  "sombis";
    }
}
