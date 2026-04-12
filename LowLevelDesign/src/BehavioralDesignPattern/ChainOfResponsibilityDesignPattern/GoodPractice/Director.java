package BehavioralDesignPattern.ChainOfResponsibilityDesignPattern.GoodPractice;

public class Director extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays) {
        if(leaveDays <= 14){
            System.out.println("Director approved leave");
        } else if (nextApprover != null) {
            nextApprover.processLeaveRequest(leaveDays);
        } else {
            System.out.println("Leave Request denied. Too many days!");
        }
    }
}
