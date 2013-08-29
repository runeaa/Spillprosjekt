/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

/**
 *
 * @author Rune
 */
public class Settings {
    public int WITDH = 640;
    public int HEIGHT = 420;
    public int FPS = 30;
    public double avrageFPS = 0;

    public void setAvrageFPS(double avrageFPS) {
        this.avrageFPS = avrageFPS;
    }

    public void setWITDH(int WITDH) {
        this.WITDH = WITDH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }
    
}
