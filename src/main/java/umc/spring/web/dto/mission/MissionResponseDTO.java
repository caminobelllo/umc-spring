package umc.spring.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    // 리뷰 작성
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
