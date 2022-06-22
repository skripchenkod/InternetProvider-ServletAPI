package ua.skrychenko.internetprovider.dao;

public interface TariffDao {

    void editTariff(String id, String newName, String newPrice);

    void editPriceOfTariff(int id, int newPrice);

    void deleteTariff(int id);
}