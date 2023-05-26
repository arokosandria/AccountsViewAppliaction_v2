package pl.coderslab.accountsview.carddeposit;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface CardDepositMapper {
    CardDepositMapper INSTANCE = Mappers.getMapper(CardDepositMapper.class);
    CardDepositDto toDto(CardDeposit cardDeposit);

}

