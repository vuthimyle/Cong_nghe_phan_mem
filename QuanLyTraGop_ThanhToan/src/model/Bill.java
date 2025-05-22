package model;

import java.sql.Date;

public class Bill {
    private String id;
    private Date dueDate;
    private int amountDue;
    private int amountPaid;
    private int remainingAmount;
    private Date paymentDate;
    private String status;
    private Client c;

    public Bill() {
        super();
    }

    public Bill(String id, Date dueDate, int amountDue, int amountPaid, int remainingAmount, Date paymentDate, String status, Client c) {
        super();
        this.id = id;
        this.dueDate = dueDate;
        this.amountDue = amountDue;
        this.amountPaid = amountPaid;
        this.remainingAmount = remainingAmount;
        this.paymentDate = paymentDate;
        this.status = status;
        this.c = c;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(int amountDue) {
        this.amountDue = amountDue;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(int remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }
}
