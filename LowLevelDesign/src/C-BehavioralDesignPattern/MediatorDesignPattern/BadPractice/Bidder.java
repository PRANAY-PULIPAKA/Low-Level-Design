package BehavioralDesignPattern.MediatorDesignPattern.BadPractice;

public class Bidder {
    String name;
    int bid;

    public Bidder(String name) {
        this.name = name;
    }

    public void placeBid(int amount, Bidder[] bidders) {
        this.bid = amount;
        System.out.println(name + "Placed a bid: " + amount);
        for (Bidder b : bidders) {
            if (b != this) {
                b.receiveBid(this, amount);
            }
        }
    }

    public void receiveBid(Bidder bidder, int amount) {
        System.out.println(name + " is notified: " + bidder.name +
                " placed a bid of " + amount);
    }
}

