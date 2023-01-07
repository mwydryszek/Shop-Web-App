package pl.excercise.jpa.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.model.projections.AddressAndTotalPrice;
import pl.excercise.jpa.model.projections.dtos.AddressAndTotalPriceDTO;
import pl.excercise.jpa.model.projections.dtos.AddressCountryStreetZipCodeDTO;
import pl.excercise.jpa.model.projections.dtos.TotalPriceByCityDTO;
import pl.excercise.jpa.service.AddressService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/find-By-Country-Or-Street/{countryOrStreet}")
    public List<AddressDTO> getAddressByCountryOrStreet(@PathVariable("countryOrStreet") String countryOrStreet){
        return addressService.getAddressEntitiesByCountryOrStreet(countryOrStreet);
    }

    @GetMapping("/find-By-Customers-Older-Than-Param/{date}")
    public List<AddressDTO> getAddressEntitiesByCustomersOlderThanParam(@PathVariable("date")LocalDate date){
        return addressService.getAddressEntitiesByCustomersOlderThanParam(date);
    }

    @GetMapping("/get-Address-Country-ZipCode")
    public List<AddressCountryStreetZipCodeDTO> getAllAddressCountryStreetZipCode(){
        return addressService.getAllAddressCountryStreetZipCode();
    }

    @GetMapping("/find-By-Total-Price-Bigger-Than-Param/{price}")
    public List<AddressAndTotalPriceDTO> getAddressEntitiesByTotalPriceBiggerThanParam(@PathVariable("price") BigDecimal price){
        return addressService.getAddressEntitiesByTotalPriceBiggerThanParam(price);
    }

    @GetMapping("/get-Total-Price-By-City/{city}")
    public List<TotalPriceByCityDTO> getTotalPriceByCity(@PathVariable("city") String city){
        return addressService.getTotalPriceByCity(city);
    }

}
