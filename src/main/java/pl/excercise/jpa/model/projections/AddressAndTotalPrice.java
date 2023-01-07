package pl.excercise.jpa.model.projections;

import java.math.BigDecimal;

public interface AddressAndTotalPrice {

    String getStreet();

    String getCountry();

    String getCity();

    BigDecimal getTotalPrice();

}
