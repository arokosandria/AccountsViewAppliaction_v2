package pl.coderslab.accountsview.person;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person dtoTo(PersonDto person);
   PersonDto toDto(Person person);



}
