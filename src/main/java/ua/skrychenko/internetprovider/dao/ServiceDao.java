package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.entity.ServiceEntity;
import ua.skrychenko.internetprovider.entity.TariffEntity;

import java.util.List;
import java.util.Map;

public interface ServiceDao {
    Map<ServiceEntity, List<TariffEntity>> getAll();
}