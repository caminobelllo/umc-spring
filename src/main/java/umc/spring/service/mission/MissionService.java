package umc.spring.service.mission;

import umc.spring.domain.Mission;
import umc.spring.web.dto.mission.MissionRequestDTO;

public interface MissionService {
    Mission addMission(MissionRequestDTO.AddMissionDTO request);
}
