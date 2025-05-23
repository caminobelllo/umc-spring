package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

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

    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return null;
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(List<Review> reviewList) {
        return null;
    }

}
