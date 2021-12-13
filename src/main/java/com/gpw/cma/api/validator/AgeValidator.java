package com.gpw.cma.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, LocalDate> {

    private static final int YEARS_NEED_TO_DRINK_ALCOHOL = 18;

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Your age should be 18+").addConstraintViolation();
        return java.time.temporal.ChronoUnit.YEARS.between(LocalDate.now().atStartOfDay(), localDate.atStartOfDay())
                >= YEARS_NEED_TO_DRINK_ALCOHOL;
    }

    @Override
    public void initialize(Age constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}