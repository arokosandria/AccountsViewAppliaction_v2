package pl.coderslab.accountsview.accountdeposit;

import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountDepositMapper {

    AccountDepositMapper INSTANCE = Mappers.getMapper(AccountDepositMapper.class);
    AccountDepositDto toDto(AccountDeposit accountDeposit);

}
