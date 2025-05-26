package umc.spring.service.mission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.memberMission.MemberMissionResponseDTO;
import umc.spring.web.dto.memberMission.MissionChallengeRequestDTO;

public interface MemberMissionService {
    
    void updateMissionStatus(MissionChallengeRequestDTO.ChallengeMissionDTO request, MissionStatus status);

    Page<MemberMission> getInProgressMissionList(Long memberId, Integer page);

}
