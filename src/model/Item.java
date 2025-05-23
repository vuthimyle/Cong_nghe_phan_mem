package model;

public class Item {
    private int id;
    private String name;
    private String unit;
    private int price;
    private Partner p;

    public Item() {
        super();
    }

    public Item(int id, String name, String unit, int price, Partner p) {
        super();
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.p = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Partner getP() {
        return p;
    }

    public void setP(Partner p) {
        this.p = p;
    }
}
