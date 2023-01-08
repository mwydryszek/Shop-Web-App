package pl.excercise.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.excercise.jpa.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	// 1. Stwórz metodę, która wyciągnie encje Product z najwyższą wartością price.

		Optional<ProductEntity> findFirstByOrderByPriceDesc();


	 //* 2. Stwórz metodę, która wyciągnie obiekt Page<Product>.

		Page<ProductEntity> findAll(Pageable pageable);


	 //* 3. Stwórz metodę, która wyciąganie unikalną listę encji Product, po polu Product.orders.customer.firstName

		@Query("SELECT p FROM ProductEntity p JOIN p.orders o JOIN o.customer c WHERE c.firstName = :firstName")
		List<ProductEntity> findProductEntitiesByCustomerFirstName(@Param("firstName") String firstName);

}
