package umc.spring.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CustomErrorHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.region.RegionRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddStoreDTO request) {

        // region 조회
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.REGION_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request);

        region.addStore(newStore);

        return storeRepository.save(newStore);
    }
}
