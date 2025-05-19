package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.mission.MissionChallengeService;
import umc.spring.service.mission.MissionService;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;
import umc.spring.web.dto.missionChallenge.MissionChallengeRequestDTO;

@Tag(name="미션", description = "미션 추가 및 도전 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;
    private final MissionChallengeService missionChallengeService;

    // 미션 추가하는 API
    @Operation(summary = "미션 추가하기", description = "특정 가게에 미션을 추가합니다.")
    @PostMapping
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(
            @RequestBody @Valid MissionRequestDTO.AddMissionDTO request) {

        Mission mission = missionService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }

    // 미션 도전하는 API
    @Operation(summary = "미션 도전하기", description = "가게의 미션을 도전 중인 미션에 추가합니다.")
    @PatchMapping("/challenge")
    public ApiResponse<String> challengeMission(
            @RequestBody @Valid MissionChallengeRequestDTO.ChallengeMissionDTO request) {
        missionChallengeService.challengeMission(request);
        return ApiResponse.onSuccess("미션 도전!!");
    }
}
