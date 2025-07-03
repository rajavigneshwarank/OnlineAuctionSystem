

import java.time.LocalDateTime;
import java.util.*;

public class Seller extends User {

    List<Item> itemsOwned;
    List<Auction> auctionsCreated;

    public Seller(int id,String name,String email){
        super(id,name,email);
        this.itemsOwned = new ArrayList<>();
        this.auctionsCreated  = new ArrayList<>();
    }

   public void addItem(Item item){
        itemsOwned.add(item);

   }


   public Auction createAuction(Item item, LocalDateTime start, LocalDateTime end){

        Auction auction = new Auction(AuctionIdGenerator.getNextId(),item,this,start,end);

        auctionsCreated.add(auction);
        System.out.println(name  + " created auction with " +auction.getId() + " for the item " + item.getName());
        return auction;

   }

    public List<Item> getItemsOwned(){
        return itemsOwned;
    }

    public List<Auction> getAuctionsCreated(){

        return auctionsCreated;

    }
}
