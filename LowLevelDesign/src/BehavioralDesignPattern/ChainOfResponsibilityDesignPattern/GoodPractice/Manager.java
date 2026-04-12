package BehavioralDesignPattern.ChainOfResponsibilityDesignPattern.GoodPractice;

public class Manager extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays) {
        if(leaveDays <= 7){
            System.out.println("Manager approved leave");
        } else if(nextApprover != null){
                nextApprover.processLeaveRequest(leaveDays);
            }
        }
}
