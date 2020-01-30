package ShoeShop;

public class Order {

    private int ID;
    private String datum;
    private int customerId;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getDatum() {
        return datum;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }
}
