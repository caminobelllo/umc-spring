package umc.spring.service.member;

import umc.spring.domain.Member;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.member.MemberResponseDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDTO request);

    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
