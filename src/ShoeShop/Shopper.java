package ShoeShop;

public class Shopper {
    private int ID;
    private int orderId;
    private String name;
    private String password;
    private String area;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setArea(String adress) {
        this.area = adress;
    }

    public String getArea() {
        return area;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}