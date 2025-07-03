public class AuctionIdGenerator {

    private static int id=1;

    public static int getNextId(){
        return id++;
    }
}
