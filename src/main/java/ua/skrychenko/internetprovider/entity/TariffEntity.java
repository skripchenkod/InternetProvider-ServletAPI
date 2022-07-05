package ua.skrychenko.internetprovider.entity;

public class TariffEntity {
    private int id;
    private String name;
    private String price;

    public TariffEntity(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public TariffEntity(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}
