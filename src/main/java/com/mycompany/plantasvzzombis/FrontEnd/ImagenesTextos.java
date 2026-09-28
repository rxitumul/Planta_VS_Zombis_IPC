package com.mycompany.plantasvzzombis.FrontEnd;

import javax.swing.*;
import java.awt.*;

public interface ImagenesTextos {
    public default ImageIcon setImagenes(int dimencionW, int dimencionH, String ruta) {
        ImageIcon tarjetaDeZombi = new ImageIcon(getClass().getResource(ruta));
        Image imagenRedimencion = tarjetaDeZombi.getImage().getScaledInstance(dimencionW, dimencionH,
                Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimencion);
    }

}
