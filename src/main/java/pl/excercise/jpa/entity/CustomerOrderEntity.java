package pl.excercise.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "customer_order")
public class CustomerOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_order_seq_generator")
    @SequenceGenerator(name = "customer_order_seq_generator", sequenceName = "customer_order_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(scale = 19, precision = 2, nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany(mappedBy = "orders")
    private Set<ProductEntity> products = new LinkedHashSet<>();
}
