package ua.skrychenko.internetprovider.service;

import ua.skrychenko.internetprovider.dao.ServiceDao;
import ua.skrychenko.internetprovider.dao.ServiceDaoImpl;
import ua.skrychenko.internetprovider.dao.TariffDao;
import ua.skrychenko.internetprovider.dao.TariffDaoImpl;
import ua.skrychenko.internetprovider.dto.TariffDto;
import ua.skrychenko.internetprovider.entity.ServiceEntity;
import ua.skrychenko.internetprovider.entity.TariffEntity;
import ua.skrychenko.internetprovider.mapper.TariffMapper;

import java.util.List;
import java.util.Map;

public class ServiceService {
    private final ServiceDao serviceDao = new ServiceDaoImpl();
    private final TariffDao tariffDao = new TariffDaoImpl();
    private final TariffMapper tariffMapper = new TariffMapper();

    public Map<ServiceEntity, List<TariffEntity>> getAll(String sortBy) {
        return serviceDao.getAll(sortBy);
    }

    public List<TariffDto> getTariff(String service) {
        return tariffMapper.tariffEntitiesToDto(tariffDao.getTariff(service));
    }

}
