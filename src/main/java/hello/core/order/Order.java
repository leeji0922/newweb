package hello.core.order;

public class Order {

    private Long memberID;
    private String itemName;
    private int itemPrice;
    private int dicountPrice;

    public Order(Long memberID, String itemName, int itemPrice, int dicountPrice) {
        this.memberID = memberID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.dicountPrice = dicountPrice;
    }

    public int calculatePrice() {
        return itemPrice - dicountPrice;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDicountPrice() {
        return dicountPrice;
    }

    public void setDicountPrice(int dicountPrice) {
        this.dicountPrice = dicountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberID=" + memberID +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", dicountPrice=" + dicountPrice +
                '}';
    }
}
