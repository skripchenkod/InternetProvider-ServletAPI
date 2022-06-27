package ua.skrychenko.internetprovider.mapper;

import ua.skrychenko.internetprovider.dto.BalanceDto;
import ua.skrychenko.internetprovider.entity.BalanceEntity;

import java.util.ArrayList;
import java.util.List;

public class BalanceMapper {
    public List<BalanceDto> balanceEntitiesToDtos(List<BalanceEntity> balanceEntity){
        List<BalanceDto> balanceDtos = new ArrayList<>();

        for (BalanceEntity entity : balanceEntity) {
            balanceDtos.add(new BalanceDto(entity.getSum(), entity.getStatus()));
        }
        return balanceDtos;
    }
}
