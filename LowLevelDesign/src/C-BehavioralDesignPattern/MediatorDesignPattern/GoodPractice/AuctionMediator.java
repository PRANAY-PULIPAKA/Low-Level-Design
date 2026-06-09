package BehavioralDesignPattern.MediatorDesignPattern.GoodPractice;

public interface AuctionMediator {
    public void registerBidder(Bidder bidder);
    public void placeBid(Bidder bidder, int amount);
}
