package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.memberMission.MemberMissionResponseDTO;
import umc.spring.web.dto.memberMission.MissionChallengeRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;

import java.util.List;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(MissionChallengeRequestDTO.ChallengeMissionDTO request, Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    // 내가 진행 중인 미션
    public static MemberMissionResponseDTO.MissionInProgressDTO toMissionInProgressDTO(MemberMission memberMission) {

        // store가 null인 경우 처리를 위해서 분리  (MemberMission -> Mission -> Store)
        Store store = memberMission.getMission().getStore();

        return MemberMissionResponseDTO.MissionInProgressDTO.builder()
                .missionId(memberMission.getMission().getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .missionStatus(memberMission.getStatus())
                .reward(memberMission.getMission().getReward())
                .storeName(store != null ? store.getName() : null)
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionListDTO memberMissionListDTO(Page<MemberMission> memberMissions) {

        List<MemberMissionResponseDTO.MissionInProgressDTO> memberMissionList = memberMissions.stream()
                .map(MemberMissionConverter::toMissionInProgressDTO)
                .toList();

        return MemberMissionResponseDTO.MemberMissionListDTO.builder()
                .memberMissionList(memberMissionList)
                .listSize(memberMissionList.size())
                .totalPage(memberMissions.getTotalPages())
                .totalElements(memberMissions.getTotalElements())
                .isFirst(memberMissions.isFirst())
                .isLast(memberMissions.isLast())
                .build();
    }
}
