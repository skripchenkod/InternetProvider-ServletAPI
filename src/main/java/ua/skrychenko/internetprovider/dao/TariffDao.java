package ua.skrychenko.internetprovider.dao;

public interface TariffDao {

    void editNameOfTariff(int id, String newName);

    void editPriceOfTariff(int id, int newPrice);

    void deleteTariff(int id);
}
