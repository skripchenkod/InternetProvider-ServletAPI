package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.entity.TariffEntity;

import java.util.List;

public interface TariffDao {

    void editTariff(String id, String newName, String newPrice);

    void deleteTariff(int id);

    List<TariffEntity> getTariff(String service);
}
