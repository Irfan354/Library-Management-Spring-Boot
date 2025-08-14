package library_management.library_management_system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library_management.library_management_system.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
    
}
