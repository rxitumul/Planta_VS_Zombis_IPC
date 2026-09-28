package com.mycompany.plantasvzzombis.BackEnd.Biblioteca;

import java.net.URL;

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
}
