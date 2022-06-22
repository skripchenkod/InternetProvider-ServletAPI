package ua.skrychenko.internetprovider.dao;

public interface TariffDao {

    void editTariff(String id, String newName, String newPrice);

    void deleteTariff(int id);
}