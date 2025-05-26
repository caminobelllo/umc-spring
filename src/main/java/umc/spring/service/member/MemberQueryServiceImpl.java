package umc.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CustomErrorHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.review.ReviewRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }

}
