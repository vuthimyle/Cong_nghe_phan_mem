package model;

public class Partner {
    private int id;
    private String name;
    private String address;
    private String tel;

    public Partner() {
        super();
    }

    public Partner(int id, String name, String address, String tel) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
