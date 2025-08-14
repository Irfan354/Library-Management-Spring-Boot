package library_management.library_management_system.dto;

import java.time.LocalDate;

import library_management.library_management_system.enums.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Integer memberId;
    private String firstName;
    private String lastName;
    private String phone;
    private String emergencyContact;
    private String email;
    private String address;
    private LocalDate joinedDate;
    private String idProofUrl;
    private String profilePhotoUrl;
    private MemberStatus status;

}
