package umc.spring.service.store;

import org.springframework.stereotype.Service;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.util.List;

@Service
public class StoreQueryServiceImpl implements StoreQueryService{

    @Override
    public List<ReviewResponseDTO.ReviewPreviewListDTO> getReviewList(Long storeId, Integer page) {
        return null;
    }
}
