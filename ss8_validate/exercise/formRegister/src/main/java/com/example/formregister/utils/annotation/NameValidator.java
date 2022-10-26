package com.example.formregister.utils.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<LastNameValid,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("[A-Za-z ]{4,}");
    }
}
