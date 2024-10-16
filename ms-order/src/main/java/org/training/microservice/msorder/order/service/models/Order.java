package org.training.microservice.msorder.order.service.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    private Long orId;
    @Column(name = "orderId")
    private String        orderId;
    @Column(name = "customerId")
    private Long          customerId;
    private String        customerName;
    private String        customerSurname;
    private String        phoneNumber;
    private String        orderRequestId;
    private EOrderStatus  orderStatus;
    private LocalDateTime orderDate;
    private LocalDateTime estimation;
    private BigDecimal    price;
    @Version
    private Integer orderVersion;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "order")
    private List<Meal>    meals;
}
