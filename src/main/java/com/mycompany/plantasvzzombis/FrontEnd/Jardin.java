/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.plantasvzzombis.FrontEnd;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.mycompany.plantasvzzombis.BackEnd.ConstructoresDeJardin.ConstructorDePlantas;
import com.mycompany.plantasvzzombis.FrontEnd.JDialojs.MenuDePausa;

/**
 *
 * @author ricardocastillo
 */
public class Jardin extends javax.swing.JFrame {

    private static final String RUTA_ZOMBI = "/com/ricardo/IndicadoresDeCosto/Zombie.png";
    private static final String RUTA_ZOMBI_BAILON = "/com/ricardo/IndicadoresDeCosto/ZombiBailónVersionMichel.png";
    private static final String RUTA_ZOMBI_CARACONO = "/com/ricardo/IndicadoresDeCosto/ZombiCaracono.png";
    private static final String RUTA_ZOMBI_DEPORTISTA = "/com/ricardo/IndicadoresDeCosto/ZombiDeportista.png";
    private static final String RUTA_ZOMBI_SALTADOR_GARROCHA = "/com/ricardo/IndicadoresDeCosto/ZombiSaltadorGarrocha.png";
    private static final String RUTA_ZOMBISTEIN = "/com/ricardo/IndicadoresDeCosto/Zombistein.png";
    private static final String RUTA_CEREBRO_ICONO = "/com/ricardo/Variaciones/Cerebro.png";
    private static final String RUTA_PAUSA_BOTON = "/com/ricardo/Variaciones/BotonDePausa.png";

    private int[][][] cordenadas;
    private JPanel mobimiento;

    /**
     * Creates new form Jardin
     */
    public Jardin(int cerrebros, int duracion, String[][] jardin) {
        initComponents();
        setSize(1000, 900);
        contadorDeCerebros.setText(String.valueOf(cerrebros));
        contadorTiempo.setText(String.valueOf(duracion));
        fondoPanelFondo(100000, 10000000);
        generadorDeMapaCords(jardin);
        jardinPadre.revalidate();
        jardinPadre.repaint();
        cementerio.setSize(23, 274);
        cerebrosObtenidos.setIcon(setImagenes(23, 23, RUTA_CEREBRO_ICONO));
        pausaMenu.setIcon(setImagenes(23, 23, RUTA_PAUSA_BOTON));
        zombi.setIcon(setImagenes(91, 56, RUTA_ZOMBI));
        zombiBailon.setIcon(setImagenes(91, 56, RUTA_ZOMBI_BAILON));
        zombiCaracono.setIcon(setImagenes(91, 56, RUTA_ZOMBI_CARACONO));
        zombiDeportista.setIcon(setImagenes(91, 56, RUTA_ZOMBI_DEPORTISTA));
        zombiSaltadorDeGarrocha.setIcon(setImagenes(91, 56, RUTA_ZOMBI_SALTADOR_GARROCHA));
        zombistein.setIcon(setImagenes(91, 56, RUTA_ZOMBISTEIN));
        revalidate();
        repaint();
    }

    private ImageIcon setImagenes(int dimencionW, int dimencionH, String ruta) {
        ImageIcon tarjetaDeZombi = new ImageIcon(getClass().getResource(ruta));
        Image imagenRedimencion = tarjetaDeZombi.getImage().getScaledInstance(dimencionW, dimencionH,
                Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimencion);
    }

    public ImageIcon voltearGifHorizontal(ImageIcon iconoOriginal) {
        int ancho = iconoOriginal.getIconWidth();
        int alto = iconoOriginal.getIconHeight();

        // Crear una imagen temporal en memoria
        BufferedImage imgBuffer = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = imgBuffer.createGraphics();

        // Dibuja la imagen invertida horizontalmente (-ancho en X, ancho de escala
        // negativo)
        g2d.drawImage(iconoOriginal.getImage(), ancho, 0, 0, alto, 0, 0, ancho, alto, null);
        g2d.dispose();

        return new ImageIcon(imgBuffer);
    }

    private void fondoPanelFondo(int ancho, int alto) {

        JPanel fondo = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                // Carga tu imagen (asegúrate de tenerla en la carpeta de recursos de tu
                // proyecto)
                Image img = new ImageIcon(getClass().getResource("/com/ricardo/Menus /Fondo.png")).getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        fondo.setSize(ancho, alto);
        jardinLayer.add(fondo, Integer.valueOf(0));

    }

    private void generadorDeMapaCords(String[][] mapa) {
        ConstructorDePlantas plantas = new ConstructorDePlantas();
        cordenadas = new int[mapa.length][mapa[0].length][2];
        JPanel panelJardin = new JPanel();

        int columna = mapa[0].length;
        int fila = mapa.length;
        int anchoTotal = columna * 80;
        int altoTotal = fila * 100;
        int y = 0;

        panelJardin.setPreferredSize(new Dimension(anchoTotal, altoTotal));
        panelJardin.setLayout(null);
        Dimension dimDinamica = new Dimension(anchoTotal, altoTotal);
        jardinLayer.setPreferredSize(dimDinamica);
        panelJardin.setBounds(0, 0, anchoTotal, altoTotal);
        jardinLayer.add(panelJardin, Integer.valueOf(1));
        for (int i = 0; i < fila; i++) {
            int x = 0;
            for (int j = 0; j < columna; j++) {

                JPanel panelJardinCasilla = null;
                if ((i + j) % 2 == 0) {
                    panelJardinCasilla = new javax.swing.JPanel() {
                        @Override
                        protected void paintComponent(java.awt.Graphics g) {
                            super.paintComponent(g);

                            Image img = new ImageIcon(getClass().getResource("/com/ricardo/Variaciones/casillaA.png"))
                                    .getImage();
                            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                        }
                    };
                } else {
                    panelJardinCasilla = new javax.swing.JPanel() {
                        @Override
                        protected void paintComponent(java.awt.Graphics g) {
                            super.paintComponent(g);
                            // Carga tu imagen (asegúrate de tenerla en la carpeta de recursos de tu
                            // proyecto)
                            Image img = new ImageIcon(getClass().getResource("/com/ricardo/Variaciones/casillaB.png"))
                                    .getImage();
                            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                        }
                    };
                }

                panelJardin.add(panelJardinCasilla);
                panelJardinCasilla.setBounds(x, y, 80, 100);
                // panelJardinCasilla.setPreferredSize(new Dimension(80, 100));
                cordenadas[i][j][0] = x;
                cordenadas[i][j][1] = y;
                x = 80 + x;
                panelJardin.doLayout();
            }
            y = 100 + y;
        }
        panelJardin.revalidate();
        panelJardin.repaint();
        jardinLayer.revalidate();
        jardinLayer.repaint();

        mobimiento = plantas.constructorDePlantas(cordenadas, mapa, altoTotal, anchoTotal, this);
        jardinLayer.add(mobimiento, Integer.valueOf(2));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cementerio = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                // Carga tu imagen (asegúrate de tenerla en la carpeta de recursos de tu
                // proyecto)
                Image img = new ImageIcon(getClass().getResource("/com/ricardo/Menus /cementerio.png")).getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jLabel2 = new javax.swing.JLabel();
        casa = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                // Carga tu imagen (asegúrate de tenerla en la carpeta de recursos de tu
                // proyecto)
                Image img = new ImageIcon(getClass().getResource("/com/ricardo/Menus /casa.png")).getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        zombiDeportista = new javax.swing.JLabel();
        zombi = new javax.swing.JLabel();
        zombiCaracono = new javax.swing.JLabel();
        zombiSaltadorDeGarrocha = new javax.swing.JLabel();
        zombiBailon = new javax.swing.JLabel();
        zombistein = new javax.swing.JLabel();
        jardinPadre = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                // Carga tu imagen (asegúrate de tenerla en la carpeta de recursos de tu
                // proyecto)
                Image img = new ImageIcon(getClass().getResource("/com/ricardo/Menus /Fondo.png")).getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jardinScrol = new javax.swing.JScrollPane();
        jardinLayer = new javax.swing.JLayeredPane();
        accionesBarra = new javax.swing.JToolBar() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                // Carga tu imagen (asegúrate de tenerla en la carpeta de recursos de tu
                // proyecto)
                Image img = new ImageIcon(getClass().getResource("/com/ricardo/Menus /FondoMadera.png")).getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        cerebrosObtenidos = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        contadorDeCerebros = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        contadorTiempo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        pausaMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout cementerioLayout = new javax.swing.GroupLayout(cementerio);
        cementerio.setLayout(cementerioLayout);
        cementerioLayout.setHorizontalGroup(
                cementerioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 88, Short.MAX_VALUE)
                        .addGroup(cementerioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        cementerioLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))));
        cementerioLayout.setVerticalGroup(
                cementerioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 274, Short.MAX_VALUE)
                        .addGroup(cementerioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        cementerioLayout.createSequentialGroup()
                                                .addContainerGap(88, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(137, Short.MAX_VALUE))));

        getContentPane().add(cementerio, java.awt.BorderLayout.LINE_START);

        casa.setLayout(new java.awt.GridLayout(0, 1, 1, 0));

        zombiDeportista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zombiDeportistaMouseClicked(evt);
            }
        });
        casa.add(zombiDeportista);

        zombi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zombiMouseClicked(evt);
            }
        });
        casa.add(zombi);

        zombiCaracono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zombiCaraconoMouseClicked(evt);
            }
        });
        casa.add(zombiCaracono);

        zombiSaltadorDeGarrocha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zombiSaltadorDeGarrochaMouseClicked(evt);
            }
        });
        casa.add(zombiSaltadorDeGarrocha);

        zombiBailon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zombiBailonMouseClicked(evt);
            }
        });
        casa.add(zombiBailon);

        zombistein.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zombisteinMouseClicked(evt);
            }
        });
        casa.add(zombistein);

        getContentPane().add(casa, java.awt.BorderLayout.LINE_END);

        jardinPadre.setBackground(new java.awt.Color(102, 0, 0));
        jardinPadre.setLayout(new java.awt.BorderLayout());

        jardinScrol.setBackground(new java.awt.Color(102, 102, 0));

        jardinLayer.setBackground(new java.awt.Color(255, 51, 204));
        jardinScrol.setViewportView(jardinLayer);

        jardinPadre.add(jardinScrol, java.awt.BorderLayout.CENTER);

        getContentPane().add(jardinPadre, java.awt.BorderLayout.CENTER);

        accionesBarra.setOpaque(false);
        accionesBarra.setFloatable(false);
        accionesBarra.setRollover(true);
        accionesBarra.add(cerebrosObtenidos);

        jSeparator3.setSeparatorSize(new java.awt.Dimension(0, 0));
        accionesBarra.add(jSeparator3);

        contadorDeCerebros.setText("0");
        accionesBarra.add(contadorDeCerebros);

        jSeparator1.setSeparatorSize(new java.awt.Dimension(200, 0));
        accionesBarra.add(jSeparator1);

        jLabel1.setText("Tiempo");
        accionesBarra.add(jLabel1);

        jSeparator4.setSeparatorSize(new java.awt.Dimension(20, 0));
        accionesBarra.add(jSeparator4);

        contadorTiempo.setText("000000");
        accionesBarra.add(contadorTiempo);

        jSeparator2.setSeparatorSize(new java.awt.Dimension(500, 0));
        accionesBarra.add(jSeparator2);

        pausaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pausaMenuMouseClicked(evt);
            }
        });
        accionesBarra.add(pausaMenu);

        getContentPane().add(accionesBarra, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int[][][] getCordenadas() {
        return cordenadas;
    }

    public JPanel getMobimiento() {
        return mobimiento;
    }

    private void pausaMenuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pausaMenuMouseClicked
        MenuDePausa pausa = new MenuDePausa(this, true);
        pausa.setVisible(true);

    }// GEN-LAST:event_pausaMenuMouseClicked

    private void zombisteinMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_zombisteinMouseClicked
        System.out.println("esten");
    }// GEN-LAST:event_zombisteinMouseClicked

    private void zombiBailonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_zombiBailónMouseClicked
        System.out.println("michel");

    }// GEN-LAST:event_zombiBailónMouseClicked

    private void zombiDeportistaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_zombiDeportistaMouseClicked
        System.out.println("deporte");
    }// GEN-LAST:event_zombiDeportistaMouseClicked

    private void zombiSaltadorDeGarrochaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_zombiSaltadorDeGarrochaMouseClicked
        System.out.println("salto");
    }// GEN-LAST:event_zombiSaltadorDeGarrochaMouseClicked

    private void zombiCaraconoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_zombiCaraconoMouseClicked
        System.out.println("cono");
    }// GEN-LAST:event_zombiCaraconoMouseClicked

    private void zombiMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_zombiMouseClicked
        System.out.println("cerebro");
    }// GEN-LAST:event_zombiMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar accionesBarra;
    private javax.swing.JPanel casa;
    private javax.swing.JPanel cementerio;
    private javax.swing.JLabel cerebrosObtenidos;
    private javax.swing.JLabel contadorDeCerebros;
    private javax.swing.JLabel contadorTiempo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JLayeredPane jardinLayer;
    private javax.swing.JPanel jardinPadre;
    private javax.swing.JScrollPane jardinScrol;
    private javax.swing.JLabel pausaMenu;
    private javax.swing.JLabel zombi;
    private javax.swing.JLabel zombiBailon;
    private javax.swing.JLabel zombiCaracono;
    private javax.swing.JLabel zombiDeportista;
    private javax.swing.JLabel zombiSaltadorDeGarrocha;
    private javax.swing.JLabel zombistein;
    // End of variables declaration//GEN-END:variables
}
