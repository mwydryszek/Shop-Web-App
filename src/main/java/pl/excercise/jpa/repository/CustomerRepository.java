package pl.excercise.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.CustomerEntity;
import pl.excercise.jpa.entity.CustomerOrderEntity;
import pl.excercise.jpa.model.CustomerDTO;
import pl.excercise.jpa.model.projections.CustomerFullName;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	 //* 1. Stwórz metodę, która wyciagnie encje Customer po polu Address.country posortowane po birthDate rosnąco.

	List<CustomerEntity> findCustomerEntitiesByAddress_CountryOrderByBirthDateAsc(String country);

	 //* 2. Stwórz metodę, która wyciągnie projekcje zawierającą jedno pole fullName, będące połączeniem firstName + surname.
	
	List<CustomerFullName> findAllByOrderBySurnameAsc();

	 //* 3. Stwórz metodę, która będzie wyciągała encje Customer dla birthDate większe niż podana data i niepustego firstName.

	@Query("SELECT c FROM CustomerEntity c WHERE c.birthDate > :date AND c.firstName is not null")
	List<CustomerEntity> findCustomerYoungerThanDateParam(@Param("date")LocalDate date);

	 //* 4. Stwórz metodę, która będzie wyciągała encje Customer dla surname zawierającego w sobie daną frazę (odpowiednik LIKE %fraza%).

	@Query("SELECT c FROM CustomerEntity c WHERE c.surname LIKE %:phrase%")
	List<CustomerEntity> findCustomerEntitiesBySurnameConstainsParam(@Param("phrase") String phrase);

}
