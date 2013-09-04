/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import java.awt.image.BufferedImage;

/**
 *
 * @author Rune
 */
public class Tile {

    private BufferedImage image;
    private boolean blocked;

    public Tile(BufferedImage image, boolean blocked) {
        this.image = image;
        this.blocked = blocked;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isBlocked() {
        return blocked;
    }
}
