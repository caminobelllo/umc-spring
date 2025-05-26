package umc.spring.web.dto.memberMission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMission;

public class MissionChallengeRequestDTO {

    @Getter
    public static class ChallengeMissionDTO {

        @NotNull
        private Long memberId;

        @NotNull
        @ExistMission
        private Long missionId;
    }
}
