package BehavioralDesignPattern.ChainOfResponsibilityDesignPattern.BadPractice;

public class LeaveRequestTraditional {

    public static void main(String[] args) {
        int leaveDays = 10;
        if(leaveDays <= 3){
            System.out.println("Supervisor approved the leave");
        } else if (leaveDays <= 7) {
            System.out.println("Manager approved the leave");
        } else if (leaveDays <= 14 ) {
            System.out.println("Director approved the leave");
        } else {
            System.out.println("leave request denied. Too many days!");
        }
    }
}
