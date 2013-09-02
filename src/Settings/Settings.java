/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

/**
 *
 * @author
 * Rune
 */
public class Settings {

    public int WITDH = 640;
    public int HEIGHT = 420;
    public int FPS = 30;
    public double avrageFPS = 0;
    public boolean sound = true;

    public void setAvrageFPS(double avrageFPS) {
        this.avrageFPS = avrageFPS;
    }

    /**
     * Set
     * the
     * desired
     * amount
     * of
     * frames
     * per
     * second
     * to
     * be
     * generated
     * for
     * the
     * visualization
     * of
     * the
     * in-game
     * graphics.
     *
     * @param
     * FPS
     * Integer
     * value
     * of
     * the
     * desired
     * FPS.
     */
    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

    public void setWITDH(int WITDH) {
        this.WITDH = WITDH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }
}