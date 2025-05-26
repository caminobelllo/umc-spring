package umc.spring.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CustomErrorHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.repository.store.StoreRepository;


@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.STORE_NOT_FOUND));

        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.STORE_NOT_FOUND));

        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

}
