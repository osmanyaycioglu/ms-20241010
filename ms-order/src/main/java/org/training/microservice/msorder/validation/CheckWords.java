package org.training.microservice.msorder.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Constraint(validatedBy = { CheckWordsImpl.class,CheckWordsObjImpl.class})
public @interface CheckWords {
    String[] words();

    String message() default "{org.training.microservice.msorder.validation.CheckWords}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
