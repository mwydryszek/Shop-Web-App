package pl.excercise.jpa.model.projections.dtos;

import lombok.*;

import java.math.BigDecimal;

@Value
public class TotalPriceByCityDTO {

    String city;
    BigDecimal totalPrice;

}
