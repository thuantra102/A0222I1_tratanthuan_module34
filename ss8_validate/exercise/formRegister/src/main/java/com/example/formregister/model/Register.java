package com.example.formregister.model;

import com.example.formregister.utils.annotation.LastNameValid;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
@Data
public class Register implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 45 , message = "Minimum - 5  characters, Maximum - 45 characters ")
    private String firstName;
    @LastNameValid
    @Size(min = 5, max = 45 , message = "Minimum - 5  characters, Maximum - 45 characters ")
    private String lastName;
    @Pattern(regexp = "0[0-9]{9}", message = "Phone Number have to correct the pattern")
    private String phoneNumber;
    @NotNull(message = "please enter your age")
    @Min(value = 18, message = "age have to be higher than 18 years old")
    private Integer age;
    @Email(message = "email have to be correct pattern")
    private String email;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Register register = (Register) target;
        if(!register.firstName.matches("[A-Za-z ]{4,}")) {
            errors.rejectValue("firstName","name.invalidFormat","Hello");
        }
    }
}
