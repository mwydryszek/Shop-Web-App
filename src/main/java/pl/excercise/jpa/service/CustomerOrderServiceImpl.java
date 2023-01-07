package pl.excercise.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.model.CustomerOrderDTO;
import pl.excercise.jpa.model.CustomerOrderMapper;
import pl.excercise.jpa.model.projections.dtos.CustomerNameSurnameTotalPriceDTO;
import pl.excercise.jpa.repository.CustomerOrderRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService{

    private final CustomerOrderRepository customerOrderRepository;

    private final CustomerOrderMapper customerOrderMapper;

    @Override
    public List<CustomerOrderDTO> getCustomerOrderEntityByTotalPriceBetweenTwoArgs(BigDecimal firstArg, BigDecimal secArg) {
        return customerOrderRepository.findCustomerOrderEntityByTotalPriceBetweenTwoArgs(firstArg, secArg).stream()
                .map(customerOrderMapper::customerOrderEntityToCustomerOrderDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<CustomerNameSurnameTotalPriceDTO> getCustomerSumTotalPrice() {
        return customerOrderRepository.getCustomerSumTotalPrice();
    }
    @Override
    public List<CustomerOrderDTO> getCustomerOrderEntityByProductName(String name) {
        return customerOrderRepository.findCustomerOrderEntityByProductName(name).stream()
                .map(customerOrderMapper::customerOrderEntityToCustomerOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerOrderDTO> getCustomerOrderEntityWithoutProducts() {
        return customerOrderRepository.findCustomerOrderEntityWithoutProducts().stream()
                .map(customerOrderMapper::customerOrderEntityToCustomerOrderDTO)
                .collect(Collectors.toList());
    }


}
