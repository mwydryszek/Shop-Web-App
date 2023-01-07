package pl.excercise.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.model.CustomerMapper;
import pl.excercise.jpa.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;

}
