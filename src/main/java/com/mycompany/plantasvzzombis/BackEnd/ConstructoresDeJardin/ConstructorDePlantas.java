package com.mycompany.plantasvzzombis.BackEnd.ConstructoresDeJardin;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.plantasvzzombis.BackEnd.Biblioteca.BibliotecaDeMobs;
import com.mycompany.plantasvzzombis.FrontEnd.Jardin;

public class ConstructorDePlantas {

    private BibliotecaDeMobs biblio = new BibliotecaDeMobs();

    public JPanel constructorDePlantas(int[][][] cords, String[][] jardin, int tamañoAlto, int tamañoAncho,
            Jardin front) {
        JPanel panel = new JPanel();
        panel.setSize(tamañoAncho, tamañoAlto);
        panel.setOpaque(false);
        panel.setLayout(null);
        int x;
        int y;
        for (int i = 0; i < jardin.length; i++) {
            for (int j = 0; j < jardin[i].length; j++) {
                String entidad = jardin[i][j];
                entidad = entidad.trim();
                if (!entidad.equals("VACIO")) {
                    x = cords[i][j][0];
                    y = cords[i][j][1];
                    JLabel planta = new JLabel();
                    ImageIcon imagen = null;
                    switch (entidad) {
                        case "LANZAGUISANTES":
                            imagen =  new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_LANZAGUISANTES());
                            break;
                        case "PATATAPUM":
                            imagen = new ImageIcon( biblio.getRUTA_DE_IMAGEN_PLANTA_PATATPUM());
                            break;
                        case "HIELAGUISANTES":
                            imagen = new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_HIELAGUISANTES());
                            break;
                        case "NUEZ":
                            imagen = new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_NUEZ_CASCAR_ARABIAS());
                            break;
                        case "CARRONIVORA":
                            imagen = new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_PLANTA_CARNIVORA());
                            break;
                        case "PINCHOHIERBA":
                            imagen = new ImageIcon( biblio.getRUTA_DE_IMAGEN_PLANTA_PINCHOHIERBA());
                            break;
                        case "BIPETIDORA":
                            imagen = new ImageIcon( biblio.getRUTA_DE_IMAGEN_PLANTA_BIPETIDORA());
                            break;
                    }
                    planta.setIcon(imagen);
                    panel.add(planta);
                    planta.setBounds(x, y, 80, 100);
                    System.out.println("Entidad: " + entidad);
                    System.out.println("Imagen: " + imagen);
                    System.out.println("X: " + x + " Y: " + y);
                }
            }
        }
        return panel;
    }

}
