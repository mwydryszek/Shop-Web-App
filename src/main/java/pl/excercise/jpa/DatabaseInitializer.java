package pl.excercise.jpa;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.excercise.jpa.entity.AddressEntity;
import pl.excercise.jpa.entity.CustomerEntity;
import pl.excercise.jpa.entity.CustomerOrderEntity;
import pl.excercise.jpa.entity.ProductEntity;
import pl.excercise.jpa.repository.AddressRepository;
import pl.excercise.jpa.repository.CustomerOrderRepository;
import pl.excercise.jpa.repository.CustomerRepository;
import pl.excercise.jpa.repository.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@AllArgsConstructor
@Component
public class DatabaseInitializer {


    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CustomerOrderRepository customerOrderRepository;

    //@PostConstruct
    public void initDatabase() {

        CustomerEntity customerEntity = CustomerEntity.builder()
                .firstName("Adam")
                .surname("Lewandowski")
                .birthDate(LocalDate.of(1990, 1, 11))
                .build();

        customerRepository.save(customerEntity);


        CustomerEntity customerEntity2 = CustomerEntity.builder()
                .firstName("Bartosz")
                .surname("Bielik")
                .birthDate(LocalDate.of(1992, 6, 25))
                .build();

        customerRepository.save(customerEntity2);

        CustomerEntity customerEntity3 = CustomerEntity.builder()
                .firstName("Marcin")
                .surname("Kowalski")
                .birthDate(LocalDate.of(1994, 7, 5))
                .build();

        customerRepository.save(customerEntity3);


        AddressEntity addressEntity = AddressEntity.builder()
                .country("Polska")
                .city("Koszalin")
                .street("Zwycięstwa")
                .zipcode("75-100")
                .customer(customerEntity)
                .build();

        addressRepository.save(addressEntity);


        AddressEntity addressEntitySecond = AddressEntity.builder()
                .country("Polska")
                .city("Koszalin")
                .street("Morska")
                .zipcode("75-200")
                .customer(customerEntity2)
                .build();

        addressRepository.save(addressEntitySecond);

        AddressEntity addressEntityThird = AddressEntity.builder()
                .country("Hiszpania")
                .city("Barcelona")
                .street("Carrer de Liszt")
                .zipcode("08923")
                .customer(customerEntity3)
                .build();

        addressRepository.save(addressEntityThird);


        ProductEntity productEntity = ProductEntity.builder()
                .name("Buty")
                .price(BigDecimal.valueOf(319))
                .availableQuantity(50)
                .build();

        productRepository.save(productEntity);

        ProductEntity productEntitySecond = ProductEntity.builder()
                .name("Koszulka")
                .price(BigDecimal.valueOf(89.99))
                .availableQuantity(100)
                .build();

        productRepository.save(productEntitySecond);

        ProductEntity productEntityThird = ProductEntity.builder()
                .name("Spodnie")
                .price(BigDecimal.valueOf(159.99))
                .availableQuantity(70)
                .build();

        productRepository.save(productEntityThird);


        Set<ProductEntity> customerProductsOrder = Set.of(productEntity, productEntitySecond);
        Set<ProductEntity> customer2ProductsOrder = Set.of(productEntitySecond, productEntityThird);
        Set<ProductEntity> customer3ProductsOrder = Set.of(productEntity, productEntityThird);

        CustomerOrderEntity customerOrderEntity = CustomerOrderEntity.builder()
                .totalPrice(customerProductsOrder.stream().map(ProductEntity::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add))
                .customer(customerEntity)
                .products(customerProductsOrder)
                .build();

        customerOrderRepository.save(customerOrderEntity);

        CustomerOrderEntity customerOrderEntitySecond = CustomerOrderEntity.builder()
                .totalPrice(customer2ProductsOrder.stream().map(ProductEntity::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add))
                .customer(customerEntity2)
                .products(customer2ProductsOrder)
                .build();

        customerOrderRepository.save(customerOrderEntitySecond);

        CustomerOrderEntity customerOrderEntityThird = CustomerOrderEntity.builder()
                .totalPrice(customer3ProductsOrder.stream().map(ProductEntity::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add))
                .customer(customerEntity3)
                .products(customer2ProductsOrder)
                .build();

        customerOrderRepository.save(customerOrderEntityThird);


    }

}
