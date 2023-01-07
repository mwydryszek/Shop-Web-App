package pl.excercise.jpa.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.excercise.jpa.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO customerToCustomerDTO(CustomerEntity customerEntity);
    CustomerEntity customerDTOToCustomer(CustomerDTO customerDTO);



}
