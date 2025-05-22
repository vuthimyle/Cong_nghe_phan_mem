package model;

import java.sql.Date;

public class ItemDetail {
    private int quantity;
    private Date date;
    private int totalPrice; 
    private Item i;

    public ItemDetail() {
        super();
    }

    public ItemDetail(int quantity, Date date, int totalPrice, Item i) {
        super();
        this.quantity = quantity;
        this.date = date;
        this.totalPrice = totalPrice;
        this.i = i;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Item getI() {
        return i;
    }

    public void setI(Item i) {
        this.i = i;
    }
}
