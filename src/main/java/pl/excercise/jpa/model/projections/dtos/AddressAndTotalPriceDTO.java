package pl.excercise.jpa.model.projections.dtos;

import lombok.*;

import java.math.BigDecimal;

@Value
public class AddressAndTotalPriceDTO {

    String country;
    String city;
    String street;
    String zipcode;
    BigDecimal totalPrice;

}
