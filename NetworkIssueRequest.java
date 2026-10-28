/*
 * Network issue affecting multiple users
 */
public class NetworkIssueRequest extends AbstractSupportRequest {

	private static final int MILESTONE_THRESHOLD = 20;
	private static final int MILESTONE_BONUS = 25;

	private final int affectedUsers;

	public NetworkIssueRequest(int id, String title, int basePoints, String affectedUsers) {
		super(id, title, basePoints);
		if (affectedUsers <= 0) {
			throw new IllegalArgumentException("Affected users must be positive");
		}
		this.affectedUsers = affectedUsers;
	}

	public int getAffectedUsers() {
		return affectedUsers;
	}
}

@Override
public int resolveFor(Technician technician) {
	if (technician == null) {
		throw new IllegalArgumentException("Technician must not be null.");
	}
	int points = getBasePoints() * affectedUsers;

	if (affectedUsers >= MILESTONE_THRESHOLD) {
		points = points + MILESTONE_BONUS;
	}

	markResolved();

	technician.addPoints(points);
	return points;
}

@Override
public String toString() {
	return "NetworkIssueRequest[" + super.toString() + ", affectedUsers=" + affectedUsers + "]";
}