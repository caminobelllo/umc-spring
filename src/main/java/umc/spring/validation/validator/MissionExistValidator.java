package umc.spring.validation.validator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.mission.MemberMissionRepository;
import umc.spring.validation.annotation.ExistMission;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, Long> {


    private final MemberMissionRepository memberMissionRepository;

    private umc.spring.domain.enums.MissionStatus status;

    @Override
    public void initialize(ExistMission constraintAnnotation) {
        this.status = constraintAnnotation.status();
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String memberIdParam = request.getParameter("memberId");

        if (memberIdParam == null || missionId == null) return false;

        Long memberId = Long.valueOf(memberIdParam);

        return !memberMissionRepository.existsByMemberIdAndMissionIdAndStatus(memberId, missionId, status);
    }
}
