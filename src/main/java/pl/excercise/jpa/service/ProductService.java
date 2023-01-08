package pl.excercise.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import pl.excercise.jpa.entity.ProductEntity;
import pl.excercise.jpa.model.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<ProductDTO> getFirstByOrderByPriceDesc();

    Page<ProductDTO> findAll(Pageable pageable);

    List<ProductDTO> getProductEntitiesByCustomerFirstName(String firstName);

}
