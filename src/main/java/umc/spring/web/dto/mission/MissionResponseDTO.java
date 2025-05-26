package umc.spring.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

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

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionPreviewDTO {
        Integer reward;
        String missionSpec;
        Period dDay;
        Long storeId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionPreviewListDTO {
        List<MissionResponseDTO.MissionPreviewDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
