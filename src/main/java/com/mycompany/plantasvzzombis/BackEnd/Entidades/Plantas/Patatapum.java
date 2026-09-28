package com.mycompany.plantasvzzombis.BackEnd.Entidades.Plantas;

import javax.swing.JLabel;

import com.mycompany.plantasvzzombis.BackEnd.Entidades.Planta;

public class Patatapum extends Planta{
public Patatapum(int salud, int damage, int cadencia,int hubicacionX, int hubicacionY, JLabel fijura) {
        super(salud, damage, cadencia,hubicacionX, hubicacionY, fijura);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void mecanica() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mecanica'");
    }
}
