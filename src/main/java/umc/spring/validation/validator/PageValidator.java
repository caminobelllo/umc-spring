package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.validation.annotation.ExistMission;

@Component
public class PageValidator implements ConstraintValidator<ExistMission, Integer> {


    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext constraintValidatorContext) {

        if (page == null || page < 1) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("페이지 번호는 1 이상이어야 합니다.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
