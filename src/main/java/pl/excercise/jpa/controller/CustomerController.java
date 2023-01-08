package pl.excercise.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.model.projections.CustomerFullName;
import pl.excercise.jpa.service.CustomerService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get-Customer-Entities-By-Address_Country-Order-By-Birth-Date-Asc/{country}")
    public List<CustomerDTO> getCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(@PathVariable String country){
        return customerService.getCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(country);
    }


    @GetMapping("/get-Customer-Entites-Full-Name")
    public List<CustomerFullName> getAllByOrderBySurnameAsc() {
        return customerService.getAllByOrderBySurnameAsc();
    }


    @GetMapping("/get-Customer-Younger-Than-Date-Param/{date}")
    public List<CustomerDTO> getCustomerYoungerThanDateParam(@PathVariable LocalDate date) {
        return customerService.getCustomerYoungerThanDateParam(date);
    }

    @GetMapping("/get-Customer-Entities-By-Surname-Constains-Param/{phrase}")
    public List<CustomerDTO> getCustomerEntitiesBySurnameConstainsParam(@PathVariable String phrase) {
        return customerService.getCustomerEntitiesBySurnameConstainsParam(phrase);
    }

}
