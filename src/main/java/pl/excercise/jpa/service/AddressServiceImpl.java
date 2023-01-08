package pl.excercise.jpa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.model.AddressDTO;
import pl.excercise.jpa.model.AddressMapper;
import pl.excercise.jpa.model.projections.dtos.AddressAndTotalPriceDTO;
import pl.excercise.jpa.model.projections.dtos.AddressCountryStreetZipCodeDTO;
import pl.excercise.jpa.model.projections.dtos.TotalPriceByCityDTO;
import pl.excercise.jpa.repository.AddressRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public List<AddressDTO> getAddressEntitiesByCountryOrStreet(String countryOrStreet) {
        return addressRepository.findAddressEntitiesByCountryOrStreet(countryOrStreet).stream()
                .map(addressMapper::addressToAddressDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressEntitiesByCustomersOlderThanParam(LocalDate date) {
        return addressRepository.findAddressEntitiesByCustomersOlderThanParam(date).stream()
                .map(addressMapper::addressToAddressDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressCountryStreetZipCodeDTO> getAllAddressCountryStreetZipCode() {
        return addressRepository.getAllAddressCountryStreetZipCode();
    }

    @Override
    public List<AddressAndTotalPriceDTO> getAddressEntitiesByTotalPriceBiggerThanParam(BigDecimal price) {
        return addressRepository.getAddressEntitiesByTotalPriceBiggerThanParam(price);
    }

    @Override
    public List<TotalPriceByCityDTO> getTotalPriceByCity(String city) {
        return addressRepository.getTotalPriceByCity(city);
    }

}
