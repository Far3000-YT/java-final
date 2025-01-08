package base;

public abstract class Person {
    private String ID;
    private String name;
    private String address;
    private String contact;

    public Person(String ID, String name, String address, String contact) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getInfos() {
        return "ID: " + ID + ", Name: " + name + ", Address: " + address + ", Contact: " + contact;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }
}