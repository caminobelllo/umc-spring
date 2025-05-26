package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.ValidPage;

@Component
public class PageValidator implements ConstraintValidator<ValidPage, Integer> {


    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext constraintValidatorContext) {

        if (page == null || page < 1) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("PAGE400") // ErrorStatus enum 이름
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
