package pl.excercise.jpa.model.projections.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressCountryStreetZipCodeDTO {

    private String country;
    private String street;
    private String zipCode;

}
