package com.mycompany.plantasvzzombis.BackEnd;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MetodosStatic {
    private static final String PATRON_NOMBRE = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9\\s]+$";

    // Constructor privado para evitar instanciación de la clase de utilidad
    private MetodosStatic() {
        throw new IllegalStateException("Clase de utilidad");
    }

    /**
     * Valida que una cadena contenga únicamente caracteres alfanuméricos,
     * espacios y acentos/ñ en español, sin caracteres especiales.
     */
    public static boolean esNombreValido(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        return nombre.matches(PATRON_NOMBRE);
    }

    public static ImageIcon setImagenes(int dimencionW, int dimencionH, URL ruta) {
        ImageIcon tarjetaDeZombi = new ImageIcon(ruta);
        Image imagenRedimencion = tarjetaDeZombi.getImage().getScaledInstance(dimencionW, dimencionH,
                Image.SCALE_SMOOTH);
                System.out.println("Ruta: " + ruta);
System.out.println("Ancho: " + tarjetaDeZombi.getIconWidth());
System.out.println("Alto: " + tarjetaDeZombi.getIconHeight());
        return new ImageIcon(imagenRedimencion);
    }
}
