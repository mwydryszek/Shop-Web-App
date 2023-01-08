package pl.excercise.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.model.CustomerMapper;
import pl.excercise.jpa.model.projections.CustomerFullName;
import pl.excercise.jpa.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(String country) {
        return customerRepository.findCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(country).stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerFullName> getCustomerEntityFullNames() {
        return customerRepository.getCustomerEntityFullNames();
    }

    @Override
    public List<CustomerDTO> getCustomerYoungerThanDateParam(LocalDate date) {
        return customerRepository.findCustomerYoungerThanDateParam(date).stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> getCustomerEntitiesBySurnameConstainsParam(String phrase) {
        return customerRepository.findCustomerEntitiesBySurnameConstainsParam(phrase).stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }
}
