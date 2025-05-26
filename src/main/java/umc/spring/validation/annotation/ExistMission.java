package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.validator.MissionExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionExistValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMission {

    String message() default "이미 해당 상태의 미션이 존재합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    // 미션 상태 검사를 위해 추가하였음
    MissionStatus status() default MissionStatus.CHALLENGING;
}
