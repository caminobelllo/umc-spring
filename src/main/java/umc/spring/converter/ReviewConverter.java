package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review) {
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddReviewDTO request) {
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .build();
    }

    public static ReviewResponseDTO.Re

}
