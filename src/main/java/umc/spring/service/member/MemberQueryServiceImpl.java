package umc.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
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

        Member member = memberRepository.findById(memberId).get();
        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }

}
