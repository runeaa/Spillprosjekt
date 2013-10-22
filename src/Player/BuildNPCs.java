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
//MERK! ikke lag en npc med npcid = 100, denne id er reservert biblioteket!

public class BuildNPCs {
    private ArrayList<NPC> list = new ArrayList<NPC>();
    public ArrayList<NPC> getLevel_one(){
        list.removeAll(list);
        list.add(new NPC(0, 130, 180, "mentorside"));
        list.add(new NPC(1, 405, 125, "blueNPC"));
        return list;
    }
    
    /*
     * npc1 = new NPC(1, 50, 300, "red");
        npcs.add(npc1);
        npc2 = new NPC(2, 315, 100, "blue");
     */
    //MERK! ikke lag en npc med npcid = 100, denne id er reservert biblioteket!
    public ArrayList<NPC> getLevel_two(){
        list.removeAll(list);
        list.add(new NPC(2, 150, 355, "blueNPC"));
        list.add(new NPC(3, 150, 292, "blueNPC"));
        list.add(new NPC(4, 150, 227, "blueNPC"));
        list.add(new NPC(5, 335, 227, "blueNPC"));
        list.add(new NPC(6, 335, 162, "blueNPC"));
        list.add(new NPC(7, 335, 97, "blueNPC"));
        
        
        return list;
    }
    public NPC getLibary(){
        NPC lib = new NPC(100,490,110,"blueNPC");
        return lib;
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
