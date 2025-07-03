import java.time.LocalDateTime;


public class Bids {

    private int id;
    private Buyer bidder;
    private Auction auction;
    private LocalDateTime timestamp;
    private double amount;


    public Bids(int id,Buyer bidder,Auction auction,double amount){
        this.id = id;
        this.bidder = bidder;
        this.auction = auction;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }


    public int getId(){
        return id;
    }
    public Buyer getBidder(){
        return bidder;

    }
    public Auction getAuction(){
        return auction;
    }
    public double getAmount(){
        return amount;

    }
    public LocalDateTime getTimeStamp(){
        return timestamp;
    }
}
