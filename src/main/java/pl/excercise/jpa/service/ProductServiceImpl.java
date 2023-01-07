package pl.excercise.jpa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.entity.ProductEntity;
import pl.excercise.jpa.model.ProductDTO;
import pl.excercise.jpa.model.ProductMapper;
import pl.excercise.jpa.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

}
