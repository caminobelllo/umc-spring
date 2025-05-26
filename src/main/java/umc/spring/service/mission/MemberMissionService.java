package umc.spring.service.mission;

import umc.spring.web.dto.memberMission.MissionChallengeRequestDTO;

public interface MemberMissionService {
    void challengeMission(MissionChallengeRequestDTO.ChallengeMissionDTO request);


}
