import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
       AuctionSystem system = new AuctionSystem();

        while(true){

            System.out.println("WELCOME TO THE ONLINE AUCTION SYSTEM");
            System.out.println("----------------------------------");

            System.out.println("1: Register seller");
            System.out.println("2 : Register Buyer");
            System.out.println("3: Add item for seller");
            System.out.println("4: Create auction");
            System.out.println("5 : Show Active Auctions");
            System.out.println("6: Place Bid");
            System.out.println("7  : End Auction and Announce Winner");
            System.out.println("0 : Exit");
            System.out.println("----------------------------------");

            System.out.println("Enter your choice:");
            int choice = s.nextInt();
            s.nextLine();

            switch(choice){

                case 1 -> {
                       System.out.println("Enter the Seller name");
                       String name = s.nextLine();
                       System.out.println("enter the email for the seller");
                       String email = s.nextLine();

                       system.registerSeller(name,email);
                }
                case 2 -> {
                    System.out.println("Enter the buyer name");
                    String name = s.nextLine();
                    System.out.println("Enetr the email for the buyer");
                    String email = s.nextLine();

                    system.registerBuyer(name,email);
                }
                case 3 -> {
                    System.out.print("Enter seller ID: ");
                    int sellerId = s.nextInt();
                    s.nextLine();
                    Seller seller = system.getSellerById(sellerId);
                    if (seller == null) {
                        System.out.println("Invalid seller.");
                        break;
                    }
                    System.out.print("Enter item name: ");
                    String itemName = s.nextLine();
                    System.out.print("Enter description: ");
                    String desc = s.nextLine();
                    system.addItem(seller, itemName, desc);
                }

                case 4 -> {
                    System.out.print("Enter seller ID: ");
                    int sellerId = s.nextInt();
                    s.nextLine();
                    Seller seller = system.getSellerById(sellerId);
                    if (seller == null || seller.getItemsOwned().isEmpty()) {
                        System.out.println("Invalid seller or no items.");
                        break;
                    }
                    System.out.println("Available items:");
                    for (Item item : seller.getItemsOwned()) {
                        System.out.println("ID: " + item.getId() + " - " + item.getName());
                    }
                    System.out.print("Enter item ID to auction: ");
                    int itemId = s.nextInt();
                    s.nextLine();

                    Item chosenItem = null;
                    for (Item item : seller.getItemsOwned()) {
                        if (item.getId() == itemId) {
                            chosenItem = item;
                            break;
                        }
                    }
                    if (chosenItem == null) {
                        System.out.println("Item not found.");
                        break;
                    }
                    LocalDateTime now = LocalDateTime.now();
                    system.createAuction(seller, chosenItem, now, now.plusMinutes(5)); // 2-minute auction
                }

                case 5 -> {
                    system.showAllActiveAuctions();
                }

                case 6 -> {
                    System.out.print("Enter buyer ID: ");
                    int buyerId = s.nextInt();
                    Buyer buyer = system.getBuyerById(buyerId);
                    if (buyer == null) {
                        System.out.println("Invalid buyer.");
                        break;
                    }
                    system.showAllActiveAuctions();
                    System.out.print("Enter auction ID: ");
                    int auctionId = s.nextInt();
                    System.out.print("Enter bid amount: ");
                    double amount = s.nextDouble();
                    Auction auction = system.getAuctionById(auctionId);
                    if (auction == null) {
                        System.out.println("Invalid auction.");
                        break;
                    }
                    buyer.addBid(auction, amount);
                }

                case 7 -> {
                    System.out.print("Enter auction ID to end: ");
                    int auctionId = s.nextInt();
                    Auction auction = system.getAuctionById(auctionId);
                    if (auction != null) {
                        auction.determineWinner();
                    } else {
                        System.out.println("Invalid auction ID.");
                    }
                }

                case 0 -> {
                    System.out.println("Exiting system...");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}