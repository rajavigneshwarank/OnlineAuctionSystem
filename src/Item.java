public class Item {

    int id;
    String itemName;
    String description;
    Seller owner;

    public Item(int id,String itemName,String desc,Seller owner){
        this.id = id;
        this.itemName = itemName;
        this.description = desc;
        this.owner = owner;
    }


    public int getId(){
        return id;
    }
    public String getName(){
        return itemName;
    }
    public String getDesc(){
        return description;
    }
}
