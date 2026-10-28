import java.util.List;

public class HelpDeskUtil {

    public static <T> void printAll(List<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items list must not be null.");
        }
        for (T item : items) {
            System.out.println(toString(item));
        }
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.toString();
    }

    public static int sumPoints(List<? extends Technician> technicians) {
        if (technicians == null) {
            throw new IllegalArgumentException("Technicians list must not be null.");
        }
        int totalPoints = 0;
        for (Technician technician : technicians) {
            totalPoints += technician.getServicePoints();
        }
        return totalPoints;
    }
}