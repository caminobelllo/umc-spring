package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CustomErrorHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddMissionDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toMission(request);
        mission.setStore(store);

        return missionRepository.save(mission);
    }

}
