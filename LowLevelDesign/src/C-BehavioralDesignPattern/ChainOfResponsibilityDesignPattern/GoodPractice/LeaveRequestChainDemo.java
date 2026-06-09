package BehavioralDesignPattern.ChainOfResponsibilityDesignPattern.GoodPractice;

public class LeaveRequestChainDemo {
    public static void main(String[] args) {
        Approver supervisor = new Supervisor();
        Approver manager = new Manager();
        Approver director = new Director();
        HR hr = new HR();

        supervisor.setNextApprover(manager);
        manager.setNextApprover(director);
        director.setNextApprover(hr);

        int leaveDays = 10;

        System.out.println("Employee requests " +leaveDays+" days of leave." );
        supervisor.processLeaveRequest(leaveDays);
    }
}
