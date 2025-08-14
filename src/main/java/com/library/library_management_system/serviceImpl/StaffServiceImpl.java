package com.library.library_management_system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_management_system.entity.Staff;
import com.library.library_management_system.repository.StaffRepository;
import com.library.library_management_system.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService  {
    @Autowired
    public StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(Long id) {
         staffRepository.deleteById(id);
    }

    

   

    

}
