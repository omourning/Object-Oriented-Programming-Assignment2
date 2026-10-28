/*
 * Network issue affecting multiple users
 */
public class NetworkIssueRequest extends AbstractSupportRequest {

	private final int affectedUsers;

	public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
		super(id, title, basePoints);
		if (affectedUsers <= 0) {
			throw new IllegalArgumentException("Affected users must be positive");
		}
		this.affectedUsers = affectedUsers;
	}

	public int getAffectedUsers() {
		return affectedUsers;
	}

	@Override
	public int resolveFor(Technician technician) {

		final int MILESTONE_THRESHOLD = 20;
		final int MILESTONE_BONUS = 25;

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
		return "NetworkIssueRequest[affectedUsers=" + affectedUsers + ", " + super.toString() + "]";
	}
}