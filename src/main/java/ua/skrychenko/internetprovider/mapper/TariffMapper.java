package ua.skrychenko.internetprovider.mapper;

import ua.skrychenko.internetprovider.dto.TariffDto;
import ua.skrychenko.internetprovider.entity.TariffEntity;

import java.util.ArrayList;
import java.util.List;

public class TariffMapper {

    public List<TariffDto> tariffEntitiesToDto (List<TariffEntity> tariffEntities){
        List<TariffDto> tariffsDto = new ArrayList<>();

        for (TariffEntity tariff : tariffEntities) {
            tariffsDto.add(new TariffDto(tariff.getName(), tariff.getPrice()));
        }
        return tariffsDto;
    }
}
