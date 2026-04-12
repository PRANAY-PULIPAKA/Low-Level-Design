package InterviewProblems.ATMMachine;

public class BalanceEnquiry implements  Transaction{

    @Override
    public void execute(Account account, CashDispenser dispenser) {
        System.out.println("Balance: " + account.getBalance());
    }


}
