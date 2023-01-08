package pl.excercise.jpa.service;

import org.springframework.cglib.core.Local;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.model.projections.CustomerFullName;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(String country);

    List<CustomerFullName> getAllByOrderBySurnameAsc();

    List<CustomerDTO> getCustomerYoungerThanDateParam(LocalDate date);

    List<CustomerDTO> getCustomerEntitiesBySurnameConstainsParam(String phrase);

}
