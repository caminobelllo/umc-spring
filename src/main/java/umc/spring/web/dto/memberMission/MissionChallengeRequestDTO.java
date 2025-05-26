package umc.spring.web.dto.memberMission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MissionChallengeRequestDTO {

    @Getter
    public static class ChallengeMissionDTO {

        @NotNull
        private Long memberId;

        @NotNull
        private Long missionId;
    }
}
