package org.training.microservice.msorder.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CheckWordsImpl implements ConstraintValidator<CheckWords, String> {
    private CheckWords anno;

    @Override
    public void initialize(final CheckWords annoParam) {
        anno = annoParam;
    }

    @Override
    public boolean isValid(final String value,
                           final ConstraintValidatorContext context) {
        for (String wordLoc : anno.words()) {
            if (value.contains(wordLoc)){
                return false;
            }
        }
        return Arrays.stream(anno.words())
                     .noneMatch(value::contains);
    }
}
