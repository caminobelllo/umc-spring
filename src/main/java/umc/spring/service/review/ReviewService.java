package umc.spring.service.review;

import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDTO;

public interface ReviewService {

    Review addReview(ReviewRequestDTO.AddReviewDTO request, Long memberId, Long missionId);
}
