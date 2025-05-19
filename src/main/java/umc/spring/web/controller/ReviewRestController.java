package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.review.ReviewService;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

@Tag(name="리뷰", description = "리뷰 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewService reviewService;

    @Operation(summary = "리뷰 추가하기", description = "특정 가게에 대한 리뷰를 추가합니다.")
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
