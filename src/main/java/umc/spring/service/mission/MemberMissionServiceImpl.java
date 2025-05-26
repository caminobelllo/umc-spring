package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.CustomErrorHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.mission.MemberMissionRepository;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.web.dto.memberMission.MissionChallengeRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public void updateMissionStatus(MissionChallengeRequestDTO.ChallengeMissionDTO request, MissionStatus status) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.MISSION_NOT_FOUND));

//        MemberMission memberMission = MemberMissionConverter.toMemberMission(request, member, mission);
//        memberMissionRepository.save(memberMission);

        // 변경된 로직
        Optional<MemberMission> existMission = memberMissionRepository
                .findByMemberIdAndMissionId(request.getMemberId(), request.getMissionId());

        if (existMission.isPresent()) {
            // 이미 존재하는 경우 -> 상태만 업데이트
            MemberMission memberMission = existMission
                    .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.MISSION_NOT_FOUND));

            if (status == MissionStatus.CHALLENGING && memberMission.getStatus() == MissionStatus.CHALLENGING) {
                throw new CustomErrorHandler(ErrorStatus.MISSION_ALREADY_EXIST);
            }
            memberMission.setStatus(status);

        } else {
            // 존재하지 않는 경우 -> 새로 생성
            MemberMission memberMission = MemberMissionConverter.toMemberMission(request, member, mission);
            memberMission.setStatus(status);
            memberMissionRepository.save(memberMission);
        }
    }

    @Override
    public Page<MemberMission> getInProgressMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return memberMissionRepository.findAllByMemberAndStatus(
                member,
                MissionStatus.CHALLENGING,
                PageRequest.of(page, 10));
    }


}
