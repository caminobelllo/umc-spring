package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.mission.MemberMissionService;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.memberMission.MemberMissionResponseDTO;


@Tag(name="회원 미션", description = "회원의 미션 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/mission")
public class MemberMissionRestController {

    private final MemberMissionService memberMissionService;

    @Operation(summary = "특정 회원의 진행 중인 미션 목록 조회 API", description = "특정 회원이 진행 중인 미션의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요.")
    @GetMapping("/list/{memberId}")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access token 필요", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access token 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access token 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디, path variable 입니다.")
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionListDTO> getMemberMissionList(@PathVariable(name = "memberId") Long memberId, @Valid @ValidPage @RequestParam(name = "page") Integer page) {

        int zeroBasedPage = page - 1;

        Page<MemberMission> memberMissionList = memberMissionService.getInProgressMissionList(memberId, zeroBasedPage);
        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionListDTO(memberMissionList));
    }
}
