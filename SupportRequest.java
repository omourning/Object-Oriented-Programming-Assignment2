/*
 * Behavior contract for every support request in help desk system
*/
public interface SupportRequest {

	//
	int getId();

	//
	String getTitle();

	//
	int getBasePoints();

	//
	boolean isResolved();

	//
	int resolveFor(Technician technician);
}