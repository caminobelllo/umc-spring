package umc.spring.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class AddMissionResultDTO {

        private Long missionId;
        private Integer reward;
        private String missionSpec;
        private LocalDateTime createdAt;
    }
}
