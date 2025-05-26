package umc.spring.web.dto.memberMission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionInProgressDTO {
        Integer reward;
        String missionSpec;
        String missionStatus;
        String storeName;
        Long missionId;
    }
}
