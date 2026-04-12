package InterviewProblems.ATMMachine;

public interface Transaction {
    void execute(Account account, CashDispenser dispenser);
}
