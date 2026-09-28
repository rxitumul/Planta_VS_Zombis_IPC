package com.mycompany.plantasvzzombis.BackEnd.ConstructoresDeJardin;

import java.io.IOException;
import java.net.URL;

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
        panel.setOpaque(true);
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
                    switch (entidad) {
                        case "LANZAGUISANTES":
                            planta.setIcon(front
                                    .voltearGifHorizontal(
                                            new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_LANZAGUISANTES())));
                            panel.add(planta);
                            planta.setBounds(x, y, 80, 100);
                            break;
                        case "PATATAPUM":
URL url = biblio.getRUTA_DE_IMAGEN_PLANTA_PATATPUM();

System.out.println(url);
                            try {
                                System.out.println(url.openConnection().getContentType());
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            planta.setIcon(front
                                    .voltearGifHorizontal(new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_PATATPUM())));
                            panel.add(planta);
                            planta.setBounds(x, y, 80, 100);
                            break;
                        case "HIELAGUISANTES":
                            planta.setIcon(front
                                    .voltearGifHorizontal(
                                            new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_HIELAGUISANTES())));
                            panel.add(planta);
                            planta.setBounds(x, y, 80, 100);
                            break;
                        case "NUEZ":
                            planta.setIcon(front
                                    .voltearGifHorizontal(
                                            new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_NUEZ_CASCAR_ARABIAS())));
                            panel.add(planta);
                            planta.setBounds(x, y, 80, 100);
                            break;
                        case "CARRONIVORA":
                            planta.setIcon(front
                                    .voltearGifHorizontal(
                                            new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_PLANTA_CARNIVORA())));
                            panel.add(planta);
                            planta.setBounds(x, y, 80, 100);
                            break;
                        case "PINCHOHIERBA":
                            planta.setIcon(front
                                    .voltearGifHorizontal(
                                            new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_PINCHOHIERBA())));
                            panel.add(planta);
                            planta.setBounds(x, y, 80, 100);
                            break;
                        case "BIPETIDORA":
                            planta.setIcon(front
                                    .voltearGifHorizontal(new ImageIcon(biblio.getRUTA_DE_IMAGEN_PLANTA_BIPETIDORA())));
                            panel.add(planta);
                            planta.setBounds(x, y, 80, 100);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return panel;
    }

}
