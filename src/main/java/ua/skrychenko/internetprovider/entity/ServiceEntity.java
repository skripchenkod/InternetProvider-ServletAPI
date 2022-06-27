package ua.skrychenko.internetprovider.entity;

import java.util.List;
import java.util.Objects;

public class ServiceEntity {

    private int id;
    private String name;
    List<TariffEntity> tariff;

    public ServiceEntity(String name, List<TariffEntity> tariff) {
        this.name = name;
        this.tariff = tariff;
    }

    public ServiceEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TariffEntity> getTariff() {
        return tariff;
    }

    public void setTariff(List<TariffEntity> tariff) {
        this.tariff = tariff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEntity that = (ServiceEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(tariff, that.tariff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tariff);
    }

    @Override
    public String toString() {
        return
                name;
    }


}
