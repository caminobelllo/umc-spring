package umc.spring.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import umc.spring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String content;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    // 미션 연관관계 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    // 연관관계 편의 메서드
    public void setStore(Store store) {
        this.store = store;
        if (!store.getReviewList().contains(this)) {
            store.getReviewList().add(this);
        }
    }
    public void setMission(Mission mission) {
        this.mission = mission;
        if (!mission.getReviewList().contains(this)) {
            mission.getReviewList().add(this);
        }
    }
    public void setMember(Member member) {
        this.member = member;
        if (!member.getReviewList().contains(this)) {
            member.getReviewList().add(this);
        }
    }

}
