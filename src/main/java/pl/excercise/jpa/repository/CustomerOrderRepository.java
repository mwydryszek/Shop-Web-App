package pl.excercise.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.CustomerOrderEntity;
import pl.excercise.jpa.model.projections.dtos.CustomerNameSurnameTotalPriceDTO;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, Long> {

	 //* 1. Stwórz metodę, która będzie wyciągającą encję CustomerOrder po polu totalPrice, którego wartość jest pomiędzy dwoma podanymi argumentami.

	@Query("SELECT co FROM CustomerOrderEntity co WHERE co.totalPrice BETWEEN :firstArg AND :secArg")
	List<CustomerOrderEntity> findCustomerOrderEntityByTotalPriceBetweenTwoArgs(@Param("firstArg") BigDecimal firstArg, @Param("secArg")BigDecimal secArg);

	 //* 2. Stwórz metodę, która wyciągnie sumy totalPrice dla poszczególnych encji Customer.

	@Query("SELECT new pl.excercise.jpa.model.projections.dtos.CustomerNameSurnameTotalPriceDTO(c.firstName, c.surname, SUM(co.totalPrice)) FROM CustomerOrderEntity co JOIN co.customer c GROUP BY c.firstName, c.surname")
	List<CustomerNameSurnameTotalPriceDTO> getCustomerSumTotalPrice();

	 //* 3. Stwórz metodę, która wyciaga encje CustomerOrder po Product.name.
	@Query("SELECT co FROM CustomerOrderEntity co join co.products p WHERE p.name = :name")
	List<CustomerOrderEntity> findCustomerOrderEntityByProductName(@Param("name") String name);


	 //* 4. Stwórz metodę, która wyciąga CustomerOrder, które nie są powiązane z żadną encją Product.

	@Query("SELECT co FROM CustomerOrderEntity co WHERE co.products is empty")
	List<CustomerOrderEntity> findCustomerOrderEntityWithoutProducts();

}
