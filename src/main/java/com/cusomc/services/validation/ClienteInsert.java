package com.cusomc.services.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Constraint(validatedBy = ClienteInsertValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface ClienteInsert {
    String message() default "Erro de alidação";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
