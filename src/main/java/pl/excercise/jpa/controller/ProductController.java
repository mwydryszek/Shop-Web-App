package pl.excercise.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import pl.excercise.jpa.model.ProductDTO;
import pl.excercise.jpa.service.ProductService;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-First-By-Order-By-Price-Desc")
    public Optional<ProductDTO> getFirstByOrderByPriceDesc() {
        return productService.getFirstByOrderByPriceDesc();
    }

    @GetMapping("/find-All")
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping("/get-Product-Entities-By-Customer-First-Name/{firstName}")
    public List<ProductDTO> getProductEntitiesByCustomerFirstName(@PathVariable("firstName") String firstName) {
        return productService.getProductEntitiesByCustomerFirstName(firstName);
    }

}
