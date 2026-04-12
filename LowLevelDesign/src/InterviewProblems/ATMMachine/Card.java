package InterviewProblems.ATMMachine;

import java.time.LocalDate;

public class Card {

    private String cardNumber;
    private String accountNumber;
    private LocalDate expiry;

    public Card(String cardNumber, String accountNumber, LocalDate expiry) {
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.expiry = expiry;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}

