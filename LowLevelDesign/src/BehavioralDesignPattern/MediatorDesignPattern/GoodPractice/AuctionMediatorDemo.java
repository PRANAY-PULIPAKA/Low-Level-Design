package BehavioralDesignPattern.MediatorDesignPattern.GoodPractice;

public class AuctionMediatorDemo {

    public static void main(String[] args) {

        AuctionMediator auctionHouse = new AuctionHouse();
        Bidder bidder1 = new Bidder("Alice", auctionHouse);
        Bidder bidder2 = new Bidder("Bod", auctionHouse);
        Bidder bidder3 = new Bidder("Charlie", auctionHouse);

        auctionHouse.registerBidder(bidder1);

        auctionHouse.registerBidder(bidder2);

        auctionHouse.registerBidder(bidder3);

        bidder1.placeBid(100);
        bidder2.placeBid(150);
        bidder3.placeBid(200);

    }
}
