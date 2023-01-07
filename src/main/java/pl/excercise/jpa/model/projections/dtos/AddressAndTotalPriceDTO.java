package pl.excercise.jpa.model.projections.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressAndTotalPriceDTO {

    private String country;
    private String city;
    private String street;
    private String zipcode;
    private BigDecimal totalPrice;

}
