package org.training.microservice.msorder.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.microservice.msorder.data.OrderDao;
import org.training.microservice.msorder.integration.PaymentProcessIntegration;
import org.training.microservice.msorder.integration.models.PaymentResponse;
import org.training.microservice.msorder.order.service.models.Order;
import org.training.microservice.msorder.order.service.models.OrderCreateReturn;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderProcessService {
    private final PaymentProcessIntegration paymentProcessIntegration;
    private final OrderDao orderDao;

    public OrderCreateReturn place(Order orderParam) {
        orderParam.setOrderId(UUID.randomUUID()
                                  .toString());

        PaymentResponse payLoc = paymentProcessIntegration.pay(orderParam.getOrderId(),
                                                               "abc1234",
                                                               new BigDecimal(1000));
        orderDao.addOrder(orderParam);
        return new OrderCreateReturn(orderParam.getOrderId(),
                                     orderParam.getOrderRequestId(),
                                     new BigDecimal(1000),
                                     ZonedDateTime.now()
                                                  .plusHours(1),
                                     payLoc.getDesc());
    }


    public OrderCreateReturn place2(Order orderParam) {
        orderParam.setOrderId(UUID.randomUUID()
                                  .toString());

        PaymentResponse payLoc = paymentProcessIntegration.pay2(orderParam.getOrderId(),
                                                                "abc1234",
                                                                new BigDecimal(1000));

        orderDao.addOrder(orderParam);
        return new OrderCreateReturn(orderParam.getOrderId(),
                                     orderParam.getOrderRequestId(),
                                     new BigDecimal(1000),
                                     ZonedDateTime.now()
                                                  .plusHours(1),
                                     payLoc.getDesc());
    }

    public OrderCreateReturn place3(Order orderParam) {
        orderParam.setOrderId(UUID.randomUUID()
                                  .toString());

        PaymentResponse payLoc = paymentProcessIntegration.pay3(orderParam.getOrderId(),
                                                                "abc1234",
                                                                new BigDecimal(1000));

        orderDao.addOrder(orderParam);
        return new OrderCreateReturn(orderParam.getOrderId(),
                                     orderParam.getOrderRequestId(),
                                     new BigDecimal(1000),
                                     ZonedDateTime.now()
                                                  .plusHours(1),
                                     payLoc.getDesc());
    }

    public OrderCreateReturn place4(Order orderParam) {
        orderParam.setOrderId(UUID.randomUUID()
                                  .toString());

        PaymentResponse payLoc = paymentProcessIntegration.pay3(orderParam.getOrderId(),
                                                                "abc1234",
                                                                new BigDecimal(1000));

        orderDao.addOrder(orderParam);
        return new OrderCreateReturn(orderParam.getOrderId(),
                                     orderParam.getOrderRequestId(),
                                     new BigDecimal(1000),
                                     ZonedDateTime.now()
                                                  .plusHours(1),
                                     payLoc.getDesc());
    }

}
