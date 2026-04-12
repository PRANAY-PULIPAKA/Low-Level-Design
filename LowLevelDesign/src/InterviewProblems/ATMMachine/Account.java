package InterviewProblems.ATMMachine;

public class Account {
    String accountNumber;
    double balance;

    public  boolean withDraw(double amount){
        if(balance < amount) return false;
        balance =- amount;
        return  true;
    }

    public double getBalance(){
        return  balance;
    }

}
