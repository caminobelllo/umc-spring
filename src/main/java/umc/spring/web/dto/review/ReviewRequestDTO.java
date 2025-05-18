package umc.spring.web.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddReviewDTO {
        @NotNull
        String content;
        @NotNull @Min(0) @Max(5)
        Float score;
    }

}
