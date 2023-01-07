package pl.excercise.jpa.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.excercise.jpa.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO productToProductDTO(ProductEntity productEntity);
    ProductEntity productDTOToProduct(ProductDTO productDTO);


}
