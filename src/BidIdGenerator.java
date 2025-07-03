public class BidIdGenerator {

    private static int id=1;

    public static int getNextId(){
        return id++;
    }
}
