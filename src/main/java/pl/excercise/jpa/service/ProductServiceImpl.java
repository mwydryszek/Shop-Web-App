package pl.excercise.jpa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.entity.AddressEntity;
import pl.excercise.jpa.entity.ProductEntity;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.model.ProductDTO;
import pl.excercise.jpa.model.ProductMapper;
import pl.excercise.jpa.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Optional<ProductDTO> getFirstByOrderByPriceDesc() {
        return productRepository.findFirstByOrderByPriceDesc().stream()
                .map(productMapper::productToProductDTO)
                .findFirst();
    }

    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {

        Page<ProductEntity> page = productRepository.findAll(pageable);

        return page.map(productMapper::productToProductDTO);
    }

    @Override
    public List<ProductDTO> getProductEntitiesByCustomerFirstName(String firstName) {
        return productRepository.findProductEntitiesByCustomerFirstName(firstName).stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }
}
