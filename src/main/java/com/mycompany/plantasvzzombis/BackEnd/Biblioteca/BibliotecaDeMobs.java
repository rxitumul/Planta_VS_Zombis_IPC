package com.mycompany.plantasvzzombis.BackEnd.Biblioteca;

import java.net.URL;

import javax.swing.JLabel;

import com.mycompany.plantasvzzombis.BackEnd.Entidades.ZombisPadre;
import com.mycompany.plantasvzzombis.BackEnd.Entidades.Zombis.ZombiBailonVersionMichel_0;
import com.mycompany.plantasvzzombis.BackEnd.Entidades.Zombis.ZombiCaracono_2;
import com.mycompany.plantasvzzombis.BackEnd.Entidades.Zombis.ZombiDeportista_3;
import com.mycompany.plantasvzzombis.BackEnd.Entidades.Zombis.ZombiSaltadorGarrocha_4;
import com.mycompany.plantasvzzombis.BackEnd.Entidades.Zombis.Zombie_1;
import com.mycompany.plantasvzzombis.BackEnd.Entidades.Zombis.Zombistein_5;

public class BibliotecaDeMobs {

        private final URL RUTA_DE_IMAGEN_PLANTA_LANZAGUISANTES = getClass()
                        .getResource("/com/ricardo/Plantas/lanzaGuisantes.gif");
        private final URL RUTA_DE_IMAGEN_PLANTA_PATATPUM = getClass()
                        .getResource("/com/ricardo/Plantas/minaPotato.gif");
        private final URL RUTA_DE_IMAGEN_PLANTA_HIELAGUISANTES = getClass()
                        .getResource("/com/ricardo/Plantas/lanzaGuisantesHielo.gif");
        private final URL RUTA_DE_IMAGEN_PLANTA_NUEZ_CASCAR_ARABIAS = getClass()
                        .getResource("/com/ricardo/Plantas/potatoAltaBase.gif");
        private final URL RUTA_DE_IMAGEN_PLANTA_PLANTA_CARNIVORA = getClass()
                        .getResource("/com/ricardo/Plantas/carnivora.gif");
        private final URL RUTA_DE_IMAGEN_PLANTA_PINCHOHIERBA = getClass()
                        .getResource("/com/ricardo/Plantas/Pinchos.png");
        private final URL RUTA_DE_IMAGEN_PLANTA_BIPETIDORA = getClass()
                        .getResource("/com/ricardo/Plantas/lanzaGuisantesDoble.gif");

        private ZombisPadre[] zombiPreferencias;

        public BibliotecaDeMobs() {
                ZombisPadre[] zombiPreferenciasLocal = { new ZombiBailonVersionMichel_0(0, 0, null, 150, 15, 150, 0.8),
                                new Zombie_1(0, 0, null, 100, 15, 50, 1),
                                new ZombiCaracono_2(0, 0, null, 200, 20, 100, 1),
                                new ZombiDeportista_3(0, 0, null, 250, 10, 150, 2),
                                new ZombiSaltadorGarrocha_4(0, 0, null, 120, 15, 100, 1.7),
                                new Zombistein_5(0, 0, null, 300, 10000, 350, 0.7) };
                zombiPreferencias = zombiPreferenciasLocal;
        }

        public URL getRUTA_DE_IMAGEN_PLANTA_BIPETIDORA() {
                return RUTA_DE_IMAGEN_PLANTA_BIPETIDORA;
        }

        public URL getRUTA_DE_IMAGEN_PLANTA_HIELAGUISANTES() {
                return RUTA_DE_IMAGEN_PLANTA_HIELAGUISANTES;
        }

        public URL getRUTA_DE_IMAGEN_PLANTA_LANZAGUISANTES() {
                return RUTA_DE_IMAGEN_PLANTA_LANZAGUISANTES;
        }

        public URL getRUTA_DE_IMAGEN_PLANTA_NUEZ_CASCAR_ARABIAS() {
                return RUTA_DE_IMAGEN_PLANTA_NUEZ_CASCAR_ARABIAS;
        }

        public URL getRUTA_DE_IMAGEN_PLANTA_PATATPUM() {
                return RUTA_DE_IMAGEN_PLANTA_PATATPUM;
        }

        public URL getRUTA_DE_IMAGEN_PLANTA_PINCHOHIERBA() {
                return RUTA_DE_IMAGEN_PLANTA_PINCHOHIERBA;
        }

        public URL getRUTA_DE_IMAGEN_PLANTA_PLANTA_CARNIVORA() {
                return RUTA_DE_IMAGEN_PLANTA_PLANTA_CARNIVORA;
        }

        public ZombisPadre creadordezombi(int y, int tipo) {
                int posiciony = y / 100;
                posiciony = posiciony * 100;

                switch (tipo) {
                        case 0:
                                return new ZombiBailonVersionMichel_0(-70, posiciony, new JLabel(), 150, 15, 150,
                                                0.8);
                        case 1:
                                return new Zombie_1(0, posiciony, new JLabel(), 100, 15, 50, 1);
                        case 2:
                                return new ZombiCaracono_2(0, posiciony, new JLabel(), 200, 20, 100,
                                                1);
                        case 3:
                                return new ZombiDeportista_3(-70, posiciony, new JLabel(), 250, 10, 150,
                                                2);

                        case 4:

                                return new ZombiSaltadorGarrocha_4(-70, posiciony, new JLabel(), 120, 15, 100,
                                                1.7);
                        case 5:

                                return new Zombistein_5(-70, posiciony, new JLabel(), 300, 999999999, 350,
                                                0.7);

                }
                return null;
        }

        public ZombisPadre[] getZombisPreferencias() {
                return zombiPreferencias;
        }
}
