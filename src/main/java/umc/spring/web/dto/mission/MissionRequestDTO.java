package umc.spring.web.dto.mission;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionDTO {
        @NotNull
        private Long storeId;
        @NotNull
        private Integer reward;
        @NotNull @Future
        private LocalDate deadline;
        @NotNull
        private String missionSpec;
    }
}
