package model;

public class Client {
    private int id;
    private String name;
    private String idCard;
    private String tel;
    private String address;
    private String email;
    private String note;

    public Client() {
        super();
    }

    public Client(int id, String name, String idCard, String tel, String address, String email, String note){
        super();
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.tel = tel;
        this.address = address; 
        this.email = email;
        this.note = note;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
