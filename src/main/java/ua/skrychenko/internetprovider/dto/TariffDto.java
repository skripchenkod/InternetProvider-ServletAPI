package ua.skrychenko.internetprovider.dto;

public class TariffDto {
    private String name;
    private String price;

    public TariffDto(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public TariffDto() {
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
