package model;

import java.util.Date;
import java.util.ArrayList;

public class Contract {
    private int id;
    private Date date;
    private String company;
    private int loanAmount;
    private float interestRate;
    private int totalAmount;
    private String terms;
    private int totalAmountPaid;
    private int remainingDebt;
    private Client c;
    private Partner p;
    private ArrayList<ItemDetail> itemDetail;
    private ArrayList<Bill> b;

    public Contract() {
        super();
        itemDetail = new ArrayList<ItemDetail>();
        b = new ArrayList<Bill>();
    }

    public Contract(int id, Date date, String company, int loanAmount, float interestRate, int totalAmount,
            String terms, int totalAmountPaid, int remainingDebt, Client c, Partner p) {
        super();
        this.id = id;
        this.date = date;
        this.company = company;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.totalAmount = totalAmount;
        this.terms = terms;
        this.totalAmountPaid = totalAmountPaid;
        this.remainingDebt = remainingDebt;
        this.c = c;
        this.p = p;
        itemDetail = new ArrayList<ItemDetail>();
        b = new ArrayList<Bill>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public int getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(int totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public int getRemainingDebt() {
        return remainingDebt;
    }

    public void setRemainingDebt(int remainingDebt) {
        this.remainingDebt = remainingDebt;
    }

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public Partner getP() {
        return p;
    }

    public void setP(Partner p) {
        this.p = p;
    }

    public ArrayList<ItemDetail> getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(ArrayList<ItemDetail> itemDetail) {
        this.itemDetail = itemDetail;
    }

    public ArrayList<Bill> getB() {
        return b;
    }

    public void setB(ArrayList<Bill> b) {
        this.b = b;
    }

    public void addItemDetail(ItemDetail item) {
        this.itemDetail.add(item);
    }
}
