package com.mycompany.plantasvzzombis.BackEnd.ConstructoresDeJardin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CargadorDeArchivo {

    private int duracionSegundos;
    private int cerebrosIniciales;
    private String[][] jardin;

    public CargadorDeArchivo() {
        this.duracionSegundos = 0;
        this.cerebrosIniciales = 0;
        this.jardin = new String[0][0];
    }

    public boolean cargadorDeJardin(File archivo) {
        if (archivo == null || !archivo.exists() || !archivo.isFile()) {
            System.err.println("El archivo no existe o es inválido.");
            return false;
        }

        StringBuilder contenido = new StringBuilder();
        try (BufferedReader lectorPrincipal = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lectorPrincipal.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }

        String texto = contenido.toString().trim();
        if (!texto.startsWith("{") || !texto.endsWith("}")) {
            System.err.println("El formato del archivo no es un JSON válido.");
            return false;
        }

        try {
            this.duracionSegundos = extraerEntero(texto, "duracionSegundos");
            this.cerebrosIniciales = extraerEntero(texto, "cerebrosIniciales");
            this.jardin = procesarJardin(texto);
            return true;
        } catch (Exception e) {
            System.err.println("Error al procesar el contenido del JSON: " + e.getMessage());
            return false;
        }
    }

    private int extraerEntero(String texto, String clave) {
        int posClave = texto.indexOf("\"" + clave + "\"");
        if (posClave == -1) {
            return 0;
        }
        int posDosPuntos = texto.indexOf(':', posClave);
        if (posDosPuntos == -1) {
            return 0;
        }

        int i = posDosPuntos + 1;
        while (i < texto.length() && !Character.isDigit(texto.charAt(i)) && texto.charAt(i) != '-') {
            i++;
        }

        if (i >= texto.length()) {
            return 0;
        }

        int inicioNumero = i;
        if (texto.charAt(i) == '-') {
            i++;
        }
        while (i < texto.length() && Character.isDigit(texto.charAt(i))) {
            i++;
        }

        String numeroStr = texto.substring(inicioNumero, i);
        try {
            return Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String[][] procesarJardin(String texto) {
        int posJardin = texto.indexOf("\"jardin\"");
        if (posJardin == -1) {
            return new String[0][0];
        }

        int inicioArregloExterior = texto.indexOf('[', posJardin);
        if (inicioArregloExterior == -1) {
            return new String[0][0];
        }

        String[][] matrizJardin = new String[0][];
        int i = inicioArregloExterior + 1;

        while (i < texto.length()) {
            int inicioFila = texto.indexOf('[', i);
            int cierreExterior = texto.indexOf(']', i);

            // Si el cierre exterior ']' aparece antes de una nueva fila o ya no hay más
            // filas
            if (cierreExterior != -1 && (inicioFila == -1 || cierreExterior < inicioFila)) {
                break;
            }

            if (inicioFila == -1) {
                break;
            }

            int finFila = texto.indexOf(']', inicioFila);
            if (finFila == -1) {
                break;
            }

            String contenidoFila = texto.substring(inicioFila + 1, finFila);
            String[] elementosFila = extraerCadenasEntreComillas(contenidoFila);
            matrizJardin = agregarFilaAMatriz(matrizJardin, elementosFila);

            i = finFila + 1;
        }

        return matrizJardin;
    }

    private String[] extraerCadenasEntreComillas(String texto) {
        if (texto == null || texto.isEmpty()) {
            return new String[0];
        }

        String[] elementos = new String[0];
        int i = 0;
        while (i < texto.length()) {
            int inicio = texto.indexOf('"', i);
            if (inicio == -1) {
                break;
            }
            int fin = texto.indexOf('"', inicio + 1);
            if (fin == -1) {
                break;
            }
            String palabra = texto.substring(inicio + 1, fin);
            elementos = agregarElementoAArreglo(elementos, palabra);
            i = fin + 1;
        }
        return elementos;
    }

    private String[] agregarElementoAArreglo(String[] arregloOriginal, String nuevoElemento) {
        String[] nuevoArreglo = new String[arregloOriginal.length + 1];
        for (int i = 0; i < arregloOriginal.length; i++) {
            nuevoArreglo[i] = arregloOriginal[i];
        }
        nuevoArreglo[arregloOriginal.length] = nuevoElemento;
        return nuevoArreglo;
    }

    private String[][] agregarFilaAMatriz(String[][] matrizOriginal, String[] nuevaFila) {
        String[][] nuevaMatriz = new String[matrizOriginal.length + 1][];
        for (int i = 0; i < matrizOriginal.length; i++) {
            nuevaMatriz[i] = matrizOriginal[i];
        }
        nuevaMatriz[matrizOriginal.length] = nuevaFila;
        return nuevaMatriz;
    }

    public String consumidorDeComillas(String linea) {
        if (linea == null || linea.isEmpty()) {
            return "";
        }

        StringBuilder palabraEncontrada = new StringBuilder();
        int contador = 0;
        char caracter;

        while (contador < linea.length()) {
            caracter = linea.charAt(contador);
            if (caracter == '"') {
                contador++;

                while (contador < linea.length()) {
                    caracter = linea.charAt(contador);
                    if (caracter != '"') {
                        palabraEncontrada.append(caracter);
                    } else {
                        break;
                    }
                    contador++;
                }
                break;
            }
            contador++;
        }

        return palabraEncontrada.toString();
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public int getCerebrosIniciales() {
        return cerebrosIniciales;
    }

    public String[][] getJardin() {
        return jardin;
    }

    public void imprimirInformacion() {
        System.out.println("Duración en segundos: " + duracionSegundos);
        System.out.println("Cerebros iniciales: " + cerebrosIniciales);
        System.out.println("Filas: " + (jardin != null ? jardin.length : 0));
        if (jardin != null) {
            for (int f = 0; f < jardin.length; f++) {
                System.out.print("Fila " + f + ": ");
                for (int c = 0; c < jardin[f].length; c++) {
                    System.out.print("[" + jardin[f][c] + "] ");
                }
                System.out.println();
            }
        }
    }
}
