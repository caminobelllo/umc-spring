package umc.spring.web.dto.memberMission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.mission.MissionResponseDTO;

import java.util.List;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionInProgressDTO {
        Integer reward;
        String missionSpec;
        MissionStatus missionStatus;
        String storeName;
        Long missionId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberMissionListDTO {
        List<MemberMissionResponseDTO.MissionInProgressDTO> memberMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
