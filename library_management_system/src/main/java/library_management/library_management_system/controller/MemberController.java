package library_management.library_management_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library_management.library_management_system.dto.MemberDTO;
import library_management.library_management_system.service.MemberService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor    //auto generate constructors for classes 
public class MemberController {

    private final MemberService memberService;


    //1.post method
    @PostMapping
    public ResponseEntity<MemberDTO> saveMember(@RequestBody MemberDTO dto){
        return ResponseEntity.ok(memberService.saveMember(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable Integer id, @RequestBody MemberDTO dto){
        return ResponseEntity.ok(memberService.updateMember(id,dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Integer id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MemberDTO> deactivateMember(@PathVariable Integer id){
        memberService.deactivateMember(id);
        return ResponseEntity.noContent().build();
    }
}
