package umc.spring.repository.mission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);

    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus missionStatus, PageRequest pageRequest);

}
