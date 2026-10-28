/*
 * Setup or configuration of 1 or more devices
 */
public class DeviceSetupRequest extends AbstractSupportRequest {

	private final int deviceCount;

	public DeviceSetupRequest(int id, String title, int basePoints, String deviceCount) {
		super(id, title, basePoints);
		if (deviceCount <= 0) {
			throw new IllegalArgumentException("Device count must be positive.");
		}
		this.deviceCount = deviceCount;
	}

	public int getDeviceCount() {
		return deviceCount;
	}

}