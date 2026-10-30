import java.util.List;

public class Main{
    public static void main(String[] args){

        Technician tech1 = new Technician("Alice");
        Technician tech2 = new Technician("Bob");
        Technician tech3 = new Technician("Bob");

        AbstractSupportRequest request1 = new DeviceSetupRequest(1, "Setup Devices", 10, 5);
        AbstractSupportRequest request2 = new DeviceSetupRequest(2, "Setup Devices", 10, 3);
        AbstractSupportRequest request3 = new PasswordResetRequest(3, "Reset Password", 5, "user1");
        AbstractSupportRequest request4 = new PasswordResetRequest(4, "Reset Password", 5, "user2");
        AbstractSupportRequest request5 = new NetworkIssueRequest(5, "Network Issue", 15, 10);
        AbstractSupportRequest request6 = new NetworkIssueRequest(6, "Network Issue", 15, 25);

        HelpDesk helpDesk = new HelpDesk();

        helpDesk.addRequest(request1);
        helpDesk.addRequest(request2);
        helpDesk.addRequest(request3);
        helpDesk.addRequest(request4);
        helpDesk.addRequest(request5);
        helpDesk.addRequest(request6);

        helpDesk.assignRequest(tech1, request1.getId());
        helpDesk.assignRequest(tech1, request2.getId());
        helpDesk.assignRequest(tech2, request3.getId());
        helpDesk.assignRequest(tech2, request4.getId());

        helpDesk.resolveRequest(tech1, request1.getId());
        helpDesk.resolveRequest(tech1, request2.getId());
        helpDesk.resolveRequest(tech2, request3.getId());
        helpDesk.resolveRequest(tech2, request4.getId());

        helpDesk.printAllRequests();

        helpDesk.printAssignmentsFor(tech1);
        helpDesk.printAssignmentsFor(tech2);

        tech1.getServicePoints();
        tech2.getServicePoints();

        System.out.println(HelpDeskUtil.sumPoints(List.of(tech1, tech2)));

        System.out.println("Invalid action: Resolving a request not assigned to a technician\n");
        helpDesk.resolveRequest(tech1, request4.getId());
    }
}