package pl.excercise.jpa.model.projections.dtos;

<<<<<<< HEAD
import lombok.*;

import java.math.BigDecimal;

@Value
public class CustomerNameSurnameTotalPriceDTO {

    String firstName;
    String surname;
    BigDecimal totalPrice;
=======
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerNameSurnameTotalPriceDTO {

    private String firstName;
    private String surname;
    private BigDecimal totalPrice;
>>>>>>> feature/SP-2-CustomerOrderQueries

}
