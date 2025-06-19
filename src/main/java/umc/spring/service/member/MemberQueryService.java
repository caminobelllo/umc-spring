package umc.spring.service.member;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.member.MemberResponseDTO;

public interface MemberQueryService {

    Page<Review> getReviewList(Long memberId, Integer page);

    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
