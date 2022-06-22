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

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
