package umc.spring.web.dto.store;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDTO {
        @NotBlank
        String name;
        @NotBlank
        String address;
        @Min(0) @Max(5)
        Float score;

        String openTime;
        String closeTime;

        @Min(1)
        Long regionId;
    }
}
