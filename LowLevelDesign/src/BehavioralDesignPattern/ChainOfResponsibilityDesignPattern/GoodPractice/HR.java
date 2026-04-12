package BehavioralDesignPattern.ChainOfResponsibilityDesignPattern.GoodPractice;


//further extended
public class HR extends Approver{
    @Override
    public void processLeaveRequest(int leaveDays) {
        System.out.println("HR: Leave request requires further discussion");
    }
}
