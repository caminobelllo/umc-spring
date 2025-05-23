package umc.spring.service.store;

import umc.spring.web.dto.review.ReviewResponseDTO;

import java.util.List;

public interface StoreQueryService {

    List<ReviewResponseDTO.ReviewPreviewListDTO> getReviewList(Long storeId, Integer page);
}
