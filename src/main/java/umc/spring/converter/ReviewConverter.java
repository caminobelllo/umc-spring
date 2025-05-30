package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    // 리뷰 조회 (가게별 & 회원별 조회에서 공통으로 사용)
    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .content(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }
    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList) {

        // 뱔도의 Review DTO를 제작해 List 생성
        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDTO).toList();

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .reviewList(reviewPreviewDTOList)
                .listSize(reviewPreviewDTOList.size())
                // Page에 있는 메서드들임
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .build();
    }

}
