package library_management.library_management_system.service;

import java.util.List;

import library_management.library_management_system.dto.MemberDTO;

public interface MemberService {

    MemberDTO saveMember(MemberDTO dto);

    MemberDTO updateMember(Integer memberId, MemberDTO dto);

    MemberDTO getMemberById(Integer memberId);

    List<MemberDTO> getAllMembers();

    void deactivateMember(Integer memberId);

}
