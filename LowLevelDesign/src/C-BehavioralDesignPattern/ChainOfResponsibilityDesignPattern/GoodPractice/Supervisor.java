package BehavioralDesignPattern.ChainOfResponsibilityDesignPattern.GoodPractice;

public class Supervisor extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays) {

        if(leaveDays <= 3){
            System.out.println("Supervisor Approved the leave");
        } else if(nextApprover != null){
            nextApprover.processLeaveRequest(leaveDays);
        }
    }
}
