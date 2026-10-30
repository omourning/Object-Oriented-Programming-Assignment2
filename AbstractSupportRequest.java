public class AbstractSupportRequest implements SupportRequest {
    int id;
    String title;
    int basePoints;
    boolean resolved;

    public AbstractSupportRequest(int id2, String title2, int basePoints2) {
        this.id = id2;
        this.title = title2;
        this.basePoints = basePoints2;
        this.resolved = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getBasePoints() {
        return basePoints;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void markResolved() {
        this.resolved = true;
    }

    public String toString() {
        return "id=" + id + ", title=" + title + ", basePoints=" + basePoints + ", resolved=" + resolved + "";
    }

    public int resolveFor(Technician technician) {
        throw new UnsupportedOperationException("Subclasses must implement resolveFor method.");
    }

    public int getPointsFor(Technician technician) {
        throw new UnsupportedOperationException("Subclasses must implement getPointsFor method.");
    }

}
