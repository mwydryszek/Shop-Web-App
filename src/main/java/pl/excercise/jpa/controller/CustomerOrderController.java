package pl.excercise.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.model.CustomerOrderDTO;
import pl.excercise.jpa.model.projections.dtos.CustomerNameSurnameTotalPriceDTO;
import pl.excercise.jpa.service.CustomerOrderService;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customerorder")
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;

    @GetMapping("/find-Customer-Order-Entity-By-Total-Price-Between-Two-Args")
    public List<CustomerOrderDTO> getCustomerOrderEntityByTotalPriceBetweenTwoArgs(@RequestParam("firstArg")BigDecimal firstArg, @RequestParam("secArg") BigDecimal secArg){
        return customerOrderService.getCustomerOrderEntityByTotalPriceBetweenTwoArgs(firstArg, secArg);
    }

    @GetMapping("/get-Customer-Sum-Total-Price")
    public List<CustomerNameSurnameTotalPriceDTO> getCustomerSumTotalPrice(){
        return customerOrderService.getCustomerSumTotalPrice();
    }

    @GetMapping("/get-Customer-Order-Entity-By-Product-Name/{name}")
    public List<CustomerOrderDTO> getCustomerOrderEntityByProductName(@PathVariable("name") String name){
        return customerOrderService.getCustomerOrderEntityByProductName(name);
    }

    @GetMapping("/get-Customer-Order-Entity-Without-Products")
    public List<CustomerOrderDTO> getCustomerOrderEntityWithoutProducts(){
        return customerOrderService.getCustomerOrderEntityWithoutProducts();
    }

}
