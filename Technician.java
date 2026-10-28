import java.util.Objects;

public class Technician {
    private String name;
    private int servicePoints;

    public Technician(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Technician name cannot be blank.");
        }

        this.name = name;
        this.servicePoints = 0;
    }

    public String getName() {
        return name;
    }

    public int getServicePoints() {
        return servicePoints;
    }

    public void addPoints(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Points must be positive.");
        }

        servicePoints += amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Technician other = (Technician) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
