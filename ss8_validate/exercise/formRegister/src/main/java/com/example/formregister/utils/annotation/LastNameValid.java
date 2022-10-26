package com.example.formregister.utils.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LastNameValid {
    String message() default "last name invalid";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
