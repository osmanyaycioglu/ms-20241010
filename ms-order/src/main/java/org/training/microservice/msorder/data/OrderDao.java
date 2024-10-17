package org.training.microservice.msorder.data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.training.microservice.msorder.order.service.models.Order;

@Service
@RequiredArgsConstructor
public class OrderDao {
    private final IOrderRepository orderRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addOrder(Order orderParam) {
        orderParam.getMeals()
                  .forEach(mealParam -> mealParam.setOrder(orderParam));
        orderRepository.save(orderParam);
        // insertAnother1(orderParam);
    }

//    @Transactional(propagation = Propagation.REQUIRED)
//    public void insertAnother1(Order orderParam) {
//        insertAnother2(orderParam);
//        orderRepository.save(orderParam);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void insertAnother2(Order orderParam) {
//        orderRepository.save(orderParam);
//    }

}
