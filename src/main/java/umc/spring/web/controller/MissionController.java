package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.mission.MemberMissionService;
import umc.spring.service.mission.MissionService;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;
import umc.spring.web.dto.memberMission.MissionChallengeRequestDTO;

@Tag(name="미션", description = "미션 추가 및 도전 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;
    private final MemberMissionService missionChallengeService;

    // 미션 추가하는 API
    @Operation(summary = "미션 추가하기", description = "특정 가게에 미션을 추가합니다.")
    @PostMapping
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(
            @RequestBody @Valid MissionRequestDTO.AddMissionDTO request) {

        Mission mission = missionService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }

    // 미션 상태 변경 API
    @Operation(summary = "미션 상태를 변경하는 API", description = "가게의 미션 상태를 CHALLENGING 또는 COMPLETE로 변경합니다.")
    @PatchMapping("/{status}")
    public ApiResponse<String> challengeMission(
            @PathVariable("status") MissionStatus status,
            @RequestBody @Valid MissionChallengeRequestDTO.ChallengeMissionDTO request) {
        missionChallengeService.updateMissionStatus(request, status);
        return ApiResponse.onSuccess("미션 상태를 " + status.name() + "으로 변경");
    }
}
