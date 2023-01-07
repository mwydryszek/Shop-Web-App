package pl.excercise.jpa.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.excercise.jpa.entity.CustomerOrderEntity;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {

    CustomerOrderDTO customerOrderEntityToCustomerOrderDTO(CustomerOrderEntity customerOrderEntity);
    CustomerOrderEntity customerOrderDTOToCustomerOrderEntity(CustomerOrderDTO customerOrderDTO);

}
