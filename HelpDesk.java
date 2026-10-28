import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelpDesk {
    private Map<Integer, SupportRequest> requestsById;
    private Map<Technician, List<SupportRequest>> assignments;

    public HelpDesk() {
        requestsById = new HashMap<Integer, SupportRequest>();
        assignments = new HashMap<Technician, List<SupportRequest>>();
    }

    public void addRequest(SupportRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Request cannot be null.");
        }

        if (requestsById.containsKey(request.getId())) {
            throw new IllegalArgumentException(
                    "A request with this ID already exists.");
        }

        requestsById.put(request.getId(), request);
    }

    public SupportRequest findRequest(int id) {
        return requestsById.get(id);
    }

    public void assignRequest(Technician technician, int requestId) {
        if (technician == null) {
            throw new IllegalArgumentException(
                    "Technician cannot be null.");
        }

        SupportRequest request = findRequest(requestId);

        if (request == null) {
            throw new IllegalArgumentException(
                    "Request does not exist.");
        }

        if (request.isResolved()) {
            throw new IllegalStateException(
                    "Cannot assign a resolved request.");
        }

        // Rule: each request may be assigned to only one technician.
        for (List<SupportRequest> requestList : assignments.values()) {
            for (SupportRequest assignedRequest : requestList) {
                if (assignedRequest.getId() == requestId) {
                    throw new IllegalArgumentException(
                            "Request is already assigned.");
                }
            }
        }

        if (!assignments.containsKey(technician)) {
            assignments.put(
                    technician, new ArrayList<SupportRequest>());
        }

        assignments.get(technician).add(request);
    }

    public int resolveRequest(Technician technician, int requestId) {
        if (technician == null) {
            throw new IllegalArgumentException(
                    "Technician cannot be null.");
        }

        List<SupportRequest> technicianRequests =
                assignments.get(technician);

        if (technicianRequests == null) {
            throw new IllegalArgumentException(
                    "Technician has no assigned requests.");
        }

        for (SupportRequest request : technicianRequests) {
            if (request.getId() == requestId) {
                // Polymorphism: the request decides its own point rule.
                return request.resolveFor(technician);
            }
        }

        throw new IllegalArgumentException(
                "This request is not assigned to this technician.");
    }

    public void printAllRequests() {
        System.out.println("All Support Requests:");

        for (SupportRequest request : requestsById.values()) {
            System.out.println(request);
        }
    }

    public void printAssignmentsFor(Technician technician) {
        if (technician == null) {
            throw new IllegalArgumentException(
                    "Technician cannot be null.");
        }

        System.out.println("Assignments for " + technician.getName()
                + ":");

        List<SupportRequest> technicianRequests =
                assignments.get(technician);

        if (technicianRequests == null
                || technicianRequests.isEmpty()) {
            System.out.println("No assigned requests.");
            return;
        }

        for (SupportRequest request : technicianRequests) {
            System.out.println(request);
        }
    }
}
