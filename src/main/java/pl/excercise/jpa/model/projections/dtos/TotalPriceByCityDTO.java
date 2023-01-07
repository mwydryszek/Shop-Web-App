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
public class TotalPriceByCityDTO {

    private String city;
    private BigDecimal totalPrice;

}
