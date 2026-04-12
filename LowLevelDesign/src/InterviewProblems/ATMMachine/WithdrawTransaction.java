package InterviewProblems.ATMMachine;

public class WithdrawTransaction implements  Transaction{

    private double amount;

    public WithdrawTransaction(double amount){
        this.amount = amount;
    }
    @Override
    public void execute(Account account, CashDispenser dispenser) {
       if(account.withDraw(amount)){
          dispenser.dispenseCash(amount);
       } else{
           throw  new RuntimeException("Insufficient balance");
       }
    }
}
