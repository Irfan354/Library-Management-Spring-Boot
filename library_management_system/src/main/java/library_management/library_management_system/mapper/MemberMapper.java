package library_management.library_management_system.mapper;


import org.mapstruct.Mapper;

import library_management.library_management_system.dto.MemberDTO;
import library_management.library_management_system.entity.Member;


@Mapper(componentModel = "spring")
public interface MemberMapper {
    //converting Entity to DTO
    MemberDTO toDto(Member member);

    //converting DTO to Entity
    Member toEntity(MemberDTO memberDTO);
}
