package library_management.library_management_system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library_management.library_management_system.dto.MemberDTO;
import library_management.library_management_system.entity.Member;
import library_management.library_management_system.enums.MemberStatus;
import library_management.library_management_system.mapper.MemberMapper;
import library_management.library_management_system.repository.MemberRepository;
import library_management.library_management_system.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    private MemberMapper memberMapper;
    
    //save
    @Override
    public MemberDTO saveMember(MemberDTO dto) {
        Member member = memberMapper.toEntity(dto);
        member.setStatus(MemberStatus.ACTIVE);

        Member saved = memberRepository.save(member);
        return memberMapper.toDto(saved);
    }

    //update
    @Override
    public MemberDTO updateMember(Integer id, MemberDTO dto) {
        Member existing = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
                        existing.setFirstName(dto.getFirstName());
                        existing.setLastName(dto.getLastName());
                        existing.setPhone(dto.getPhone());
                        existing.setEmail(dto.getEmail());
                        existing.setAddress(dto.getAddress());
                        existing.setEmergencyContact(dto.getEmergencyContact());
                        return memberMapper.toDto(memberRepository.save(existing));
    }

    //get method
    @Override
    public MemberDTO getMemberById(Integer id) {
        return memberRepository.findById(id)
                .map(memberMapper :: toDto)
                .orElseThrow(() -> new RuntimeException("member not found"));
     }

    @Override
    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(memberMapper :: toDto)
                .collect(Collectors.toList());    
    }

    @Override
    public void deactivateMember(Integer memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("member not found"));
                member.setStatus(MemberStatus.INACTIVE);
                memberRepository.save(member);
    }



}
