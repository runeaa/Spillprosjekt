/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.util.ArrayList;

/**
 *
 * @author espen
 */

public class BuildNPCs {
    private ArrayList<NPC> list = new ArrayList<>();
    public ArrayList getLevel_one(){
        list.add(new NPC(11, 50, 300, "red"));
        list.add(new NPC(12, 315, 100, "blue"));
        
        return list;
        
    }
    
    /*
     * npc1 = new NPC(1, 50, 300, "red");
        npcs.add(npc1);
        npc2 = new NPC(2, 315, 100, "blue");
     */
    public ArrayList getLevel_two(){
        list.removeAll(list);
        list.add(new NPC(21, -50,100,"red"));
        list.add(new NPC(22, -50,100,"blue"));
        
        
        return list;
    }
/*      npc = BuildNPCs.getLevel_one()
        
        * npc = BuildNPCs.getLevel_two()
 * 
 * 
 * 
 * for(NPC n: npcs){
 *  n.draw(g)
 * }
 */
    
}
