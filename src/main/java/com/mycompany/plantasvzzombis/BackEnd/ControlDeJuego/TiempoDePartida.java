package com.mycompany.plantasvzzombis.BackEnd.ControlDeJuego;

import com.mycompany.plantasvzzombis.FrontEnd.Jardin;

public class TiempoDePartida extends Thread {
    private int tiempo;
    private Jardin front;
    private transient boolean pausado = false;
    private transient boolean detenido = false;

    public TiempoDePartida(int tiempo, Jardin front) {
        this.tiempo = tiempo;
        this.front = front;
    }

    @Override
    public void run() {

        contador();
    }

    private void contador() {

        while (true) {
            try {
                if (detenido) {
                    break;
                }

                if (!pausado) {
                    Thread.sleep(1000);
                    tiempo--;
                    front.cambioDeTiempo(tiempo);
                    if (tiempo == 0) {
                        break;
                    }
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        if (detenido) {
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                // TODO: handle exception
            }

        }
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }

}
