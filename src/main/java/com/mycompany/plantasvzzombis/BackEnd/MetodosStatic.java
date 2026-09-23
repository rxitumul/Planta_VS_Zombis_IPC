package com.mycompany.plantasvzzombis.BackEnd;

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

}
