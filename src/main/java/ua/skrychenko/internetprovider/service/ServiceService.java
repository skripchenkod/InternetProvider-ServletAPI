package ua.skrychenko.internetprovider.service;

import ua.skrychenko.internetprovider.dao.ServiceDao;
import ua.skrychenko.internetprovider.dao.ServiceDaoImpl;
import ua.skrychenko.internetprovider.dao.TariffDao;
import ua.skrychenko.internetprovider.dao.TariffDaoImpl;
import ua.skrychenko.internetprovider.dto.TariffDto;
import ua.skrychenko.internetprovider.mapper.TariffMapper;

import java.util.List;

public class ServiceService {
    ServiceDao serviceDao= new ServiceDaoImpl();
    TariffDao tariffDao = new TariffDaoImpl();
    TariffMapper tariffMapper = new TariffMapper();

    public List<String> getAll(){
        return serviceDao.getAll();
    }

    public List<TariffDto> getTariff(String service){
       return tariffMapper.tariffEntitiesToDto(tariffDao.getTariff(service));
    }

}
