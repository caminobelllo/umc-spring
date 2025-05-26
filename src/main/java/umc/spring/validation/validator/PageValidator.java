package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;
import umc.spring.validation.annotation.ExistMission;

@Component
public class PageValidator implements ConstraintValidator<ExistMission, Integer> {


    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext constraintValidatorContext) {

        if (page == null || page < 1) {
            throw new ConstraintViolationException("INVALID_PAGE", null);
        }
        return true;
    }
}
