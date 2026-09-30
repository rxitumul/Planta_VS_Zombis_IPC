package com.mycompany.plantasvzzombis.BackEnd;

import com.mycompany.plantasvzzombis.BackEnd.ControlDeJuego.HiloDeCerbros;
import com.mycompany.plantasvzzombis.FrontEnd.Jardin;

public class Dificultades {

    public void creadorDeCerebros(int cantidad, Jardin front, int x, int y) {

        HiloDeCerbros[] generadoresDeCerebros = new HiloDeCerbros[cantidad];
        for (int i = 0; i < generadoresDeCerebros.length; i++) {
            generadoresDeCerebros[i] = new HiloDeCerbros(front, x, y);
        }
        
    }

}
