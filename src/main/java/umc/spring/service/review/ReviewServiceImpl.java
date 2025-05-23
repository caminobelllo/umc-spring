package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CustomErrorHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.review.ReviewRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.AddReviewDTO request, Long missionId, Long memberId
    ) {

        // store, member, mission 연관
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.MISSION_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.STORE_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request);
        newReview.setMember(member);
        newReview.setStore(store);
        newReview.setMission(mission);

        return reviewRepository.save(newReview);
    }
}
