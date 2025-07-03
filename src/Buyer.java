import java.util.*;


public class Buyer extends User {

     private List<Bids> bidsPlaced;

     public Buyer(int id,String name,String email){
         super(id,name,email);
         this.bidsPlaced = new ArrayList<>();
     }

      public void addBid(Auction auction,double amount){

         Bids bid = new Bids(BidIdGenerator.getNextId(),this,auction,amount);

         auction.addBid(bid);
         bidsPlaced.add(bid);

         System.out.println(name + " placed a bid on Rs " + amount + " on auction of " + auction.getId());

      }


     public List<Bids> getBidsPlaced(){
         return bidsPlaced;
     }
}
