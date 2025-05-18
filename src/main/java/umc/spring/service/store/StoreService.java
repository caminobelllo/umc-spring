package umc.spring.service.store;

import umc.spring.domain.Store;
import umc.spring.web.dto.store.StoreRequestDTO;

public interface StoreService {

    Store addStore(StoreRequestDTO.AddStoreDTO request);
}
