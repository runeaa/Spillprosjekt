package Tasks;

/**
 *
 * @author amund
 */
public class Task {
    private final String description;
    private final int scrumPoints;
    
    public Task(String description, int scrumPoints) {
        this.description = description;
        this.scrumPoints = scrumPoints;
    }
    
    public int getScrumPoints() { return scrumPoints; }
    public String getDescription() { return description; }
}
