/*
 * Password or account rest request
 */
public class PasswordResetRequest extends AbstractSupportRequest {

	private final String accountName;

	public PasswordResetRequest(int id, String title, int basePoints, String accountName) {
		this.accountName = "";
		super(id, title, basePoints);
		if (accountName == null || accountName.isBlank()) {
			throw new IllegalArgumentException("Account name must not be null or blank.");
		}
	}

	public String getAccountName() {
		return accountName;
	}

	@Override
	public int resolveFor(Technician technician) {
		if (technician == null) {
			throw new IllegalArgumentException("Technician must not be null.");
		}
		int points = getBasePoints();

		markResolved();

		technician.addPoints(points);
		return points;
	}

	@Override
	public String toString() {
		return "PasswordResetRequest[account=" + accountName + ", " + super.toString() + "]";
	}
}