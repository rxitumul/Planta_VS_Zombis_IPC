/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.plantasvzzombis.FrontEnd;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.mycompany.plantasvzzombis.BackEnd.Biblioteca.BibliotecaDeMobs;
import com.mycompany.plantasvzzombis.BackEnd.ConstructoresDeJardin.ConstructorDePlantas;
import com.mycompany.plantasvzzombis.BackEnd.ControlDeJuego.CerebrosTiempo;
import com.mycompany.plantasvzzombis.FrontEnd.JDialojs.MenuDePausa;

/**
 *
 * @author ricardocastillo
 */
public class Jardin extends javax.swing.JFrame {

    private static final String RUTA_CEREBRO_ICONO = "/com/ricardo/Variaciones/Cerebro.png";
    private static final String RUTA_PAUSA_SELECIONADO = "/com/ricardo/Variaciones/BotonDePausaSelecionado.png";

    private static final String RUTA_ZOMBI_0_DISABLE = "/com/ricardo/IndicadoresDeCosto/0.1_ZombiBailónVersionMichel.png";
    private static final String RUTA_ZOMBI_0 = "/com/ricardo/IndicadoresDeCosto/0.2_ZombiBailónVersionMichel.png";

    private static final String RUTA_ZOMBI_1_DISABLE = "/com/ricardo/IndicadoresDeCosto/1.1_Zombie.png";
    private static final String RUTA_ZOMBI_1 = "/com/ricardo/IndicadoresDeCosto/1.2_Zombie.png";

    private static final String RUTA_ZOMBI_2_DISABLE = "/com/ricardo/IndicadoresDeCosto/2.1_ZombiCaracono.png";
    private static final String RUTA_ZOMBI_2 = "/com/ricardo/IndicadoresDeCosto/2.2_ZombiCaracono.png";

    private static final String RUTA_ZOMBI_3_DISABLE = "/com/ricardo/IndicadoresDeCosto/3.1_ZombiDeportista.png";
    private static final String RUTA_ZOMBI_3 = "/com/ricardo/IndicadoresDeCosto/3.2_ZombiDeportista.png";

    private static final String RUTA_ZOMBI_4_DISABLE = "/com/ricardo/IndicadoresDeCosto/4.1_ZombiSaltadorGarrocha.png";
    private static final String RUTA_ZOMBI_4 = "/com/ricardo/IndicadoresDeCosto/4.2_ZombiSaltadorGarrocha.png";

    private static final String RUTA_ZOMBI_5_DISABLE = "/com/ricardo/IndicadoresDeCosto/5.1_Zombistein.png";
    private static final String RUTA_ZOMBI_5 = "/com/ricardo/IndicadoresDeCosto/5.2_Zombistein.png";

    private int[][][] cordenadas;
    private JPanel mobimiento;
    private ButtonGroup grupoDeZombisButtonGroup;
    private JToggleButton[] zombis = new JToggleButton[6];
    private CerebrosTiempo cerebrosTiempo;
    private BibliotecaDeMobs bilbio = new BibliotecaDeMobs();
    private int columna;
    private int fila;

    /**
     * Creates new form Jardin
     */
    public Jardin(int cerrebros, int duracion, String[][] jardin) {
        initComponents();
        grupoDeZombisButtonGroup = new ButtonGroup();
        setSize(1000, 900);
        contadorDeCerebros.setText(String.valueOf(cerrebros));
        contadorTiempo.setText(String.valueOf(duracion));
        fondoPanelFondo(100000, 10000000);
        generadorDeMapaCords(jardin);
        jardinPadre.revalidate();
        jardinPadre.repaint();
        cementerio.setSize(23, 274);
        cerebrosObtenidos.setIcon(setImagenes(23, 23, RUTA_CEREBRO_ICONO));
        ImageIcon iconoHover = new ImageIcon(RUTA_PAUSA_SELECIONADO);
        pausaMenu.setRolloverIcon(iconoHover);
        pausaMenu.setRolloverEnabled(true);
        esteblecesdorDeBotonesZombis();
        cerebrosTiempo = new CerebrosTiempo(cerrebros, fila, columna, bilbio.getZombisPreferencias(), zombis);
        revalidate();
        repaint();
    }

    private void esteblecesdorDeBotonesZombis() {

        grupoDeZombisButtonGroup.add(zombi);
        zombi.setSelectedIcon(setImagenes(91, 56, RUTA_ZOMBI_1));
        zombi.setDisabledIcon(setImagenes(91, 56, RUTA_ZOMBI_1_DISABLE));
        zombis[1] = zombi;
        grupoDeZombisButtonGroup.add(zombiBailónVersionMichel);
        zombiBailónVersionMichel.setSelectedIcon(setImagenes(91, 56, RUTA_ZOMBI_0));
        zombiBailónVersionMichel.setDisabledIcon(setImagenes(91, 56, RUTA_ZOMBI_0_DISABLE));
        zombis[0] = zombiBailónVersionMichel;
        grupoDeZombisButtonGroup.add(zombiCaracono);
        zombiCaracono.setSelectedIcon(setImagenes(91, 56, RUTA_ZOMBI_2));
        zombiCaracono.setDisabledIcon(setImagenes(91, 56, RUTA_ZOMBI_2_DISABLE));
        zombis[2] = zombiCaracono;
        grupoDeZombisButtonGroup.add(zombiDeportista);
        zombiDeportista.setSelectedIcon(setImagenes(91, 56, RUTA_ZOMBI_3));
        zombiDeportista.setDisabledIcon(setImagenes(91, 56, RUTA_ZOMBI_3_DISABLE));
        zombis[3] = zombiDeportista;
        grupoDeZombisButtonGroup.add(zombiSaltadorGarrocha);
        zombiSaltadorGarrocha.setSelectedIcon(setImagenes(91, 56, RUTA_ZOMBI_4));
        zombiSaltadorGarrocha.setDisabledIcon(setImagenes(91, 56, RUTA_ZOMBI_4_DISABLE));
        zombis[4] = zombiSaltadorGarrocha;
        grupoDeZombisButtonGroup.add(zombistein);
        zombistein.setSelectedIcon(setImagenes(91, 56, RUTA_ZOMBI_5));
        zombistein.setDisabledIcon(setImagenes(91, 56, RUTA_ZOMBI_5_DISABLE));
        zombis[5] = zombistein;

    }

    private ImageIcon setImagenes(int dimencionW, int dimencionH, String ruta) {
        ImageIcon tarjetaDeZombi = new ImageIcon(getClass().getResource(ruta));
        Image imagenRedimencion = tarjetaDeZombi.getImage().getScaledInstance(dimencionW, dimencionH,
                Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimencion);
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

        Dimension dimDinamica = new Dimension(anchoTotal, altoTotal);
        panelJardin.setPreferredSize(dimDinamica);
        panelJardin.setLayout(null);

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

        JPanel eschucaDeMause = new JPanel();
        eschucaDeMause.setSize(anchoTotal, altoTotal);
        eschucaDeMause.setPreferredSize(dimDinamica);
        eschucaDeMause.setOpaque(false);
        eschucaDeMause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDeEschuchaUsuario(evt);
            }
        });
        jardinLayer.add(eschucaDeMause, Integer.valueOf(3));

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
        zombi = new javax.swing.JToggleButton();
        zombiBailónVersionMichel = new javax.swing.JToggleButton();
        zombiCaracono = new javax.swing.JToggleButton();
        zombiDeportista = new javax.swing.JToggleButton();
        zombiSaltadorGarrocha = new javax.swing.JToggleButton();
        zombistein = new javax.swing.JToggleButton();
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
        tiempo = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        contadorTiempo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        pausaMenu = new javax.swing.JButton();

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
                        .addGap(0, 744, Short.MAX_VALUE)
                        .addGroup(cementerioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        cementerioLayout.createSequentialGroup()
                                                .addContainerGap(326, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(369, Short.MAX_VALUE))));

        getContentPane().add(cementerio, java.awt.BorderLayout.LINE_START);

        casa.setLayout(new java.awt.GridLayout(0, 1, 1, 0));

        zombi.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/com/ricardo/IndicadoresDeCosto/1.0_Zombie.png"))); // NOI18N
        zombi.setBorderPainted(false);
        zombi.setContentAreaFilled(false);
        zombi.setFocusPainted(false);
        zombi.addActionListener(this::zombiActionPerformed);
        casa.add(zombi);

        zombiBailónVersionMichel.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/com/ricardo/IndicadoresDeCosto/0.0_ZombiBailónVersionMichel.png"))); // NOI18N
        zombiBailónVersionMichel.setBorderPainted(false);
        zombiBailónVersionMichel.setContentAreaFilled(false);
        zombiBailónVersionMichel.setFocusPainted(false);
        zombiBailónVersionMichel.addActionListener(this::zombiBailónVersionMichelActionPerformed);
        casa.add(zombiBailónVersionMichel);

        zombiCaracono.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/com/ricardo/IndicadoresDeCosto/2.0_ZombiCaracono.png"))); // NOI18N
        zombiCaracono.setBorderPainted(false);
        zombiCaracono.setContentAreaFilled(false);
        zombiCaracono.setFocusPainted(false);
        zombiCaracono.addActionListener(this::zombiCaraconoActionPerformed);
        casa.add(zombiCaracono);

        zombiDeportista.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/com/ricardo/IndicadoresDeCosto/3.0_ZombiDeportista.png"))); // NOI18N
        zombiDeportista.setBorderPainted(false);
        zombiDeportista.setContentAreaFilled(false);
        zombiDeportista.setFocusPainted(false);
        zombiDeportista.addActionListener(this::zombiDeportistaActionPerformed);
        casa.add(zombiDeportista);

        zombiSaltadorGarrocha.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/com/ricardo/IndicadoresDeCosto/4.0_ZombiSaltadorGarrocha.png"))); // NOI18N
        zombiSaltadorGarrocha.setBorderPainted(false);
        zombiSaltadorGarrocha.setContentAreaFilled(false);
        zombiSaltadorGarrocha.setFocusPainted(false);
        zombiSaltadorGarrocha.addActionListener(this::zombiSaltadorGarrochaActionPerformed);
        casa.add(zombiSaltadorGarrocha);

        zombistein.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/com/ricardo/IndicadoresDeCosto/5.0_Zombistein.png"))); // NOI18N
        zombistein.setBorderPainted(false);
        zombistein.setContentAreaFilled(false);
        zombistein.setFocusPainted(false);
        zombistein.addActionListener(this::zombisteinActionPerformed);
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

        contadorDeCerebros.setForeground(new java.awt.Color(102, 255, 255));
        contadorDeCerebros.setText("0");
        accionesBarra.add(contadorDeCerebros);

        jSeparator1.setSeparatorSize(new java.awt.Dimension(200, 0));
        accionesBarra.add(jSeparator1);

        tiempo.setForeground(new java.awt.Color(102, 255, 255));
        tiempo.setText("Tiempo");
        accionesBarra.add(tiempo);

        jSeparator4.setSeparatorSize(new java.awt.Dimension(20, 0));
        accionesBarra.add(jSeparator4);

        contadorTiempo.setForeground(new java.awt.Color(102, 255, 255));
        contadorTiempo.setText("000000");
        accionesBarra.add(contadorTiempo);

        jSeparator2.setSeparatorSize(new java.awt.Dimension(500, 0));
        accionesBarra.add(jSeparator2);

        pausaMenu.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/com/ricardo/Variaciones/BotonDePausa.png"))); // NOI18N
        pausaMenu.setBorderPainted(false);
        pausaMenu.setContentAreaFilled(false);
        pausaMenu.setFocusPainted(false);
        pausaMenu.setFocusable(false);
        pausaMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pausaMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pausaMenu.addActionListener(this::pausaMenuActionPerformed);
        accionesBarra.add(pausaMenu);

        getContentPane().add(accionesBarra, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zombiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_zombiActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_zombiActionPerformed

    private void zombiBailónVersionMichelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_zombiBailónVersionMichelActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_zombiBailónVersionMichelActionPerformed

    private void zombiCaraconoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_zombiCaraconoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_zombiCaraconoActionPerformed

    private void zombiDeportistaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_zombiDeportistaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_zombiDeportistaActionPerformed

    private void zombiSaltadorGarrochaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_zombiSaltadorGarrochaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_zombiSaltadorGarrochaActionPerformed

    private void zombisteinActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_zombisteinActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_zombisteinActionPerformed

    private void pausaMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_pausaMenuActionPerformed
        // TODO add your handling code here:
        MenuDePausa pausa = new MenuDePausa(this, true);
        pausa.setVisible(true);
    }// GEN-LAST:event_pausaMenuActionPerformed

    public int[][][] getCordenadas() {
        return cordenadas;
    }

    public JPanel getMobimiento() {
        return mobimiento;
    }

    private void panelDeEschuchaUsuario(java.awt.event.MouseEvent evt) {
        int x = evt.getX();
        int y = evt.getY();
        System.out.println("posicion del mause x:" + x + " y:" + y);
    }

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JLayeredPane jardinLayer;
    private javax.swing.JPanel jardinPadre;
    private javax.swing.JScrollPane jardinScrol;
    private javax.swing.JButton pausaMenu;
    private javax.swing.JLabel tiempo;
    private javax.swing.JToggleButton zombi;
    private javax.swing.JToggleButton zombiBailónVersionMichel;
    private javax.swing.JToggleButton zombiCaracono;
    private javax.swing.JToggleButton zombiDeportista;
    private javax.swing.JToggleButton zombiSaltadorGarrocha;
    private javax.swing.JToggleButton zombistein;
    // End of variables declaration//GEN-END:variables
}
