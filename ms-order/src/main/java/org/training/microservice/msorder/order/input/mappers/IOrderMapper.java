package org.training.microservice.msorder.order.input.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.training.microservice.msorder.order.input.models.OrderDto;
import org.training.microservice.msorder.order.input.models.OrderPlaceResponse;
import org.training.microservice.msorder.order.service.models.Order;
import org.training.microservice.msorder.order.service.models.OrderCreateReturn;

@Mapper
public interface IOrderMapper {

    IOrderMapper ORDER_MAPPER = Mappers.getMapper(IOrderMapper.class);

    Order toOrder(OrderDto order);

    OrderDto toOrder(Order order);


    OrderPlaceResponse toOrderPlaceResponse(OrderCreateReturn createReturnParam);


}
