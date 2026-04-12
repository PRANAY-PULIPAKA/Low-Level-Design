package InterviewProblems.ATMMachine;


public class ATM {

    private ATMState state = ATMState.IDLE;
    private BankService bankService;
    private Card currentCard;
    private  Account currentAccount;

    private CashDispenser cashDispenser;

    private void insertCard(Card card){
        this.currentCard = card;
        this.state = ATMState.CARD_INSERTED;
    }
    public boolean enterPin(int pin){
        boolean valid = bankService.validatePin(currentCard, pin);
        if(valid){
            currentAccount = bankService.getAccount(currentCard.getAccountNumber());
            state= ATMState.AUTHENTICATED;
        }
        return  valid;
    }

    public void  performTransaction(Transaction txn){
        state = ATMState.TRANSACTION_IN_PROGRESS;
        txn.execute(currentAccount, cashDispenser);
        state = ATMState.AUTHENTICATED;
    }
    public void ejectCard() {
        currentCard = null;
        currentAccount = null;
        state = ATMState.IDLE;
    }


}
