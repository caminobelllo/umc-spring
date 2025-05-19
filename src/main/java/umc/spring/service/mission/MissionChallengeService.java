package umc.spring.service.mission;

import umc.spring.web.dto.missionChallenge.MissionChallengeRequestDTO;

public interface MissionChallengeService {
    void challengeMission(MissionChallengeRequestDTO.ChallengeMissionDTO request);
}
