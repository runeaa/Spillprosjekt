/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import Player.NPC;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author amund
 */
public class Map {
    private List<NPC> npcs = new ArrayList<>();
    
    public Map(List<NPC> npcs){
        this.npcs=npcs;
    }

    /**
     * @return the npcs
     */
    public List<NPC> getNpcs() {
        return npcs;
    }

    /**
     * @param npcs the npcs to set
     */
    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }
}
