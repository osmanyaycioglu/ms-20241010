package org.training.microservice.msorder.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CheckWordsObjImpl implements ConstraintValidator<CheckWords, Object> {
    private CheckWords anno;

    @Override
    public void initialize(final CheckWords annoParam) {
        anno = annoParam;
    }

    @Override
    public boolean isValid(final Object value,
                           final ConstraintValidatorContext context) {
        Field[] declaredFieldsLoc = value.getClass()
                                         .getDeclaredFields();
        for (Field declaredFieldLoc : declaredFieldsLoc) {
            if (declaredFieldLoc.getType()
                                .equals(String.class)) {
                try {
                    declaredFieldLoc.setAccessible(true);
                    String oLoc = (String) declaredFieldLoc.get(value);
                    for (String wordLoc : anno.words()) {
                        if (oLoc.contains(wordLoc)) {
                            return false;
                        }
                    }
                } catch (IllegalAccessException eParam) {
                }
            }

        }
        return true;
    }
}
