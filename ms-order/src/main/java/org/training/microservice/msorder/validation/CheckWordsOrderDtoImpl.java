package org.training.microservice.msorder.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.training.microservice.msorder.order.input.models.OrderDto;

import java.util.Arrays;

public class CheckWordsOrderDtoImpl implements ConstraintValidator<CheckWords, OrderDto> {
    private CheckWords anno;

    @Override
    public void initialize(final CheckWords annoParam) {
        anno = annoParam;
    }

    @Override
    public boolean isValid(final OrderDto value,
                           final ConstraintValidatorContext context) {
        return true;
    }
}
