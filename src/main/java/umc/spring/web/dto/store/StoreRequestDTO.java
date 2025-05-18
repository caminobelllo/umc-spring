package umc.spring.web.dto.store;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDTO {
        @NotBlank
        String name;
        @NotBlank
        String address;

        Float score;
        String openTime;
        String closeTime;
    }
}
