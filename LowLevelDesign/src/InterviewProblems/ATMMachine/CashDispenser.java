package InterviewProblems.ATMMachine;

public class CashDispenser {
    private double availableCash = 100000;
    public void dispenseCash(double amount){
        if(availableCash < amount){
            throw new RuntimeException("ATM is out of cash");
        }
       availableCash -= amount;
    }
}
