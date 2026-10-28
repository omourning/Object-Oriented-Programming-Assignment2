/*
 * Setup or configuration of 1 or more devices
 */
public class DeviceSetupRequest extends AbstractSupportRequest {

	private final int deviceCount;

	public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount) {
		super(id, title, basePoints);
		if (deviceCount <= 0) {
			throw new IllegalArgumentException("Device count must be positive.");
		}
		this.deviceCount = deviceCount;
	}

	public int getDeviceCount() {
		return deviceCount;
	}

	@Override
	public int resolveFor(Technician technician) {
		if (technician == null) {
			throw new IllegalArgumentException("Technician must not be null.");
		}
		int points = getBasePoints() * deviceCount;

		markResolved();

		technician.addPoints(points);
		return points;
	}

	@Override
	public String toString() {
		return "DeviceSetupRequest[devices=" + deviceCount + ", " + super.toString() + "]";
	}
}