import java.time.LocalDateTime;
import java.util.*;


public class Auction {
    private int id;
   private Seller seller;
    private Item item;
    private AuctionStatus status;

    private LocalDateTime start;
    private LocalDateTime end;

    private List<Bids> bids;
    private Bids winningBid;


    public Auction(int id,Item item,Seller seller,LocalDateTime start,LocalDateTime end){
        this.id=id;
        this.seller=seller;
        this.start =start;
        this.item = item;

        this.end=end;
        this.status = AuctionStatus.ACTIVE;
        this.bids = new ArrayList<>();

    }




    public AuctionStatus getStatus(){

        LocalDateTime now = LocalDateTime.now();

        if(now.isAfter(end)){
            status = AuctionStatus.ENDED;

        }

        return status;
    }

    public void addBid(Bids bid){

        if(getStatus()==AuctionStatus.ACTIVE){
            bids.add(bid);
        }
        else{
            System.out.println("Auction is closed and the bid is rejected...");
        }
    }

    public void determineWinner(){

        if(!bids.isEmpty()){
            winningBid = Collections.max(bids, Comparator.comparing(Bids::getAmount));
            System.out.println("Auction #" + id + " won by " + winningBid.getBidder().getName() +
                    " for ₹" + winningBid.getAmount());
        }
        else{
            System.out.println("Auction is Closed");
        }
        this.status = AuctionStatus.ENDED;
    }


    public int getId(){
        return id;
    }

    public Item getItem(){
        return item;
    }

    public List<Bids> getBids(){
        return bids;
    }
    public Bids getWinningBid(){
        return winningBid;
    }

}
