package org.training.microservice.msorder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.training.microservice.msorder.order.service.models.Order;
import org.training.microservice.msorder.order.service.models.OrderSearch;

import java.util.List;
import java.util.concurrent.Future;

public interface IOrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByCustomerName(String customerName);

    List<Order> findByCustomerNameAndCustomerSurnameOrderByCustomerNameAsc(String customerName,String surname);

    List<Order> findByCustomerNameIn(List<String> customerName);

    @Query("select o from Order o where o.customerName=?1")
    List<Order> searchCustomerName(String customerName);

    @Query(value = "select * from order o where o.customer_name=?1",nativeQuery = true)
    List<Order> searchNativeCustomerName(String customerName);

    @Query("select o.customerId,o.orderId from Order o where o.customerName=?1")
    List<Object[]> searchCustomerNameGetSome(String customerName);

    @Query("select new org.training.microservice.msorder.order.service.models.OrderSearch(o.orderId,o.customerId) from Order o where o.customerName=?1")
    List<OrderSearch> searchCustomerNameGetObj(String customerName);

}
