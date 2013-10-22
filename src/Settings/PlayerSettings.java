package Settings;

/**
 *
 * @author
 * haavamoa
 */
public class PlayerSettings {

    public String system;
    public String playerName;
    public String devMethod;
    public static  final int waterfall = 0;
    public static final int spiral = 1;
    public static final int up = 2;
    public static final int scrum = 3;
    public int difficulity = -1; //-1 = no diff choosen.
    public static final int EASY = 0;
    public static final int NORMAL = 1;
    public static final int HARD = 2;

    public String getSystem() {
        return system;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getDevMethod() {
        return devMethod;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setDevMethod(String devMethod) {
        this.devMethod = devMethod;
    }

    public void setDifficulity(int difficulity) {
        this.difficulity = difficulity;
    }

    public int getDevMethodInt(){
        if(devMethod.equalsIgnoreCase("SCRUM")){
            return scrum;
        }else if(devMethod.equalsIgnoreCase("Unified Processing")){
            return up;
        }else if(devMethod.equalsIgnoreCase("Fossefallsmetoden")){
            return waterfall;
        }else if(devMethod.equalsIgnoreCase("Spiralmetoden")){
            return spiral;
        }
        return -1;
    }
}