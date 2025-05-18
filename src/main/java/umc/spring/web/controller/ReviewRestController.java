package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.review.ReviewService;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/missions/{missionId}")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> addReview(
            @RequestBody @Valid ReviewRequestDTO.AddReviewDTO request,
            @PathVariable Long missionId,
            @RequestParam Long memberId     // 임시
            ) {

        Review review = reviewService.addReview(request, missionId, memberId);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }

}
