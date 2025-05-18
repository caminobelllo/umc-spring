package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.store.StoreRequestDTO;
import umc.spring.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.AddStoreResultDTO toAddStoreResultDTO(Store store) {
        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddStoreDTO request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .openTime(request.getOpenTime())
                .closeTime(request.getCloseTime())
                .build();
    }
}
