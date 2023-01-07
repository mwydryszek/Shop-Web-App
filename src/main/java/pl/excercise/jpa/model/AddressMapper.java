package pl.excercise.jpa.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.excercise.jpa.entity.AddressEntity;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO addressToAddressDTO(AddressEntity addressEntity);
    AddressEntity addressDTOToAddress(AddressDTO addressDTO);

}
