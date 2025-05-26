package umc.spring.service.store;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.util.List;

public interface StoreQueryService {

    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
