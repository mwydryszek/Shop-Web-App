package pl.excercise.jpa.model.projections.dtos;


import lombok.*;

@Value
public class AddressCountryStreetZipCodeDTO {

    String country;
    String street;
    String zipCode;

}
