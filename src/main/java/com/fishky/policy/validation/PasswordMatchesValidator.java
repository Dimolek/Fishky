package com.fishky.policy.validation;

import com.fishky.dto.user.UserCreateRequestDto;
import com.fishky.policy.validation.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserCreateRequestDto> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(final UserCreateRequestDto user, final ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getConfirmPassword());
    }

}