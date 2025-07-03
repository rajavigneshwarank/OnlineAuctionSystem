import java.util.*;
import java.time.LocalDateTime;

public class AuctionSystem {

     private List<Buyer> buyers;
     private List<Seller> sellers;
     private List<Auction> auctions;
     private List<Item> items;


     public AuctionSystem(){
         this.buyers = new ArrayList<>();
         this.sellers = new ArrayList<>();
         this.auctions = new ArrayList<>();
         this.items = new ArrayList<>();

     }

      public Buyer registerBuyer(String name,String email){
         Buyer buyer = new Buyer(buyers.size()+1,name,email);
         buyers.add(buyer);
         System.out.println("Buyer Registered " + name);
         return buyer;
      }

    public Seller registerSeller(String name,String email){
        Seller seller = new Seller(sellers.size()+1,name,email);
        sellers.add(seller);
        System.out.println("Seller Registered " + name);
        return seller;
    }

    public Item addItem(Seller seller,String itemName,String desc){
         Item item = new Item(ItemIdGenerator.getNextId(),itemName,desc,seller);
         items.add(item);
         seller.addItem(item);
         System.out.println("Item added " + itemName);
         return item;

    }


    public Auction createAuction(Seller seller, Item item, LocalDateTime start, LocalDateTime end) {
        Auction auction = seller.createAuction(item, start, end);
        auctions.add(auction);
        return auction;
    }

    public void showAllActiveAuctions() {
        System.out.println("\n=== Active Auctions ===");
        for (Auction auction : auctions) {
//            if (auction.getStatus() == AuctionStatus.ACTIVE) {
//                System.out.println("Auction ID: " + auction.getId() + ", Item: " + auction.getItem().getName());
//            }
            if (auction.getItem() != null) {
                System.out.println("Auction ID: " + auction.getId() + ", Item: " + auction.getItem().getName());
            } else {
                System.out.println("Auction ID: " + auction.getId() + " has no item assigned.");
            }
        }
    }

    public Auction getAuctionById(int id) {
        for (Auction auction : auctions) {
            if (auction.getId() == id) {
                return auction;
            }
        }
        return null;
    }

    public Buyer getBuyerById(int id) {
        for (Buyer buyer : buyers) {
            if (buyer.getId() == id) return buyer;
        }
        return null;
    }

    public Seller getSellerById(int id) {
        for (Seller seller : sellers) {
            if (seller.getId() == id) return seller;
        }
        return null;
    }
}


