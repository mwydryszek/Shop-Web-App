package pl.excercise.jpa.service;


import pl.excercise.jpa.model.CustomerOrderDTO;
import pl.excercise.jpa.model.projections.dtos.CustomerNameSurnameTotalPriceDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerOrderService {

    List<CustomerOrderDTO> getCustomerOrderEntityByTotalPriceBetweenTwoArgs(BigDecimal firstArg, BigDecimal secArg);
    List<CustomerNameSurnameTotalPriceDTO> getCustomerSumTotalPrice();
    List<CustomerOrderDTO> getCustomerOrderEntityByProductName(String name);

    List<CustomerOrderDTO> getCustomerOrderEntityWithoutProducts();

}
