package pl.excercise.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.AddressEntity;
import pl.excercise.jpa.model.projections.AddressAndTotalPrice;
import pl.excercise.jpa.model.projections.dtos.AddressAndTotalPriceDTO;
import pl.excercise.jpa.model.projections.dtos.AddressCountryStreetZipCodeDTO;
import pl.excercise.jpa.model.projections.dtos.TotalPriceByCityDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    //* 1. Stwórz metodę, która będzie wyciągała encję Address po polach Country lub Street

    @Query("SELECT a FROM AddressEntity a WHERE a.country = :countryOrStreet OR a.street = :countryOrStreet")
    List<AddressEntity> findAddressEntitiesByCountryOrStreet(@Param("countryOrStreet")String countryOrStreet);

    //* 2. Stwórz metodę, która wyciąganie encje Address dla wartości mniejszych birthDate powiązanej encji Customer, od podanej wartości.

    @Query("SELECT a FROM AddressEntity a JOIN CustomerEntity c WHERE c.birthDate < :date")
    List<AddressEntity> findAddressEntitiesByCustomersOlderThanParam(@Param("date") LocalDate date);

    //* 3. Stwórz metodę, która wyciągnie projekcje wszystkich encji Address, zawierającą tylko pola country, street, zipcode.

    @Query("SELECT new pl.excercise.jpa.model.projections.dtos.AddressCountryStreetZipCodeDTO(a.country, a.street, a.zipcode) FROM AddressEntity a")
    List<AddressCountryStreetZipCodeDTO> getAllAddressCountryStreetZipCode();

    //* 4. Stwórz metodę, która wyciągnie unikalne encje Address powiązane z encją Customer, których chociaż jedno z CustomerOrderEntity miało pole totalPrice większe od podanego w argumencie.

    @Query("SELECT DISTINCT new pl.excercise.jpa.model.projections.dtos.AddressAndTotalPriceDTO(a.country, a.city, a.street, a.zipcode, co.totalPrice) FROM AddressEntity a JOIN a.customer AS c JOIN c.orders co WHERE co.totalPrice>:value")
    List<AddressAndTotalPriceDTO> getAddressEntitiesByTotalPriceBiggerThanParam(BigDecimal value);


    //* 5. Stwórz metodę, która będzie sumować totalPrice z CustomerOrderEntity dla podanego argumentu city.

    @Query("SELECT new pl.excercise.jpa.model.projections.dtos.TotalPriceByCityDTO(a.city, SUM(co.totalPrice)) FROM AddressEntity a JOIN a.customer c JOIN c.orders co WHERE a.city=:city GROUP BY a.city")
    List<TotalPriceByCityDTO> getTotalPriceByCity(String city);

}
