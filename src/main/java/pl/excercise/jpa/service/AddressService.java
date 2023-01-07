package pl.excercise.jpa.service;

import org.springframework.data.repository.query.Param;
import pl.excercise.jpa.entity.CustomerOrderEntity;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.model.CustomerOrderDTO;
import pl.excercise.jpa.model.projections.AddressAndTotalPrice;
import pl.excercise.jpa.model.projections.dtos.AddressAndTotalPriceDTO;
import pl.excercise.jpa.model.projections.dtos.AddressCountryStreetZipCodeDTO;
import pl.excercise.jpa.model.projections.dtos.TotalPriceByCityDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AddressService {

    List<AddressDTO> getAddressEntitiesByCountryOrStreet(String countryOrStreet);

    List<AddressDTO> getAddressEntitiesByCustomersOlderThanParam(LocalDate date);

    List<AddressCountryStreetZipCodeDTO> getAllAddressCountryStreetZipCode();

    List<AddressAndTotalPriceDTO> getAddressEntitiesByTotalPriceBiggerThanParam(BigDecimal price);

    List<TotalPriceByCityDTO> getTotalPriceByCity(String city);
}
