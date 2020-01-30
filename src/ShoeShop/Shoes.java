package ShoeShop;

public class Shoes {
    private int ID;
    private int size;
    private int price;
    private int amountInStock;
    private String brand;
    private String colour;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return getColour() + " " + getBrand() + " in size " + getSize() + " costs " + getPrice() + ":-\n";
    }
}
