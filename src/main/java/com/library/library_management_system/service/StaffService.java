package com.library.library_management_system.service;

import java.util.List;

import com.library.library_management_system.entity.Staff;

public interface StaffService {
    List<Staff> getAllStaff();

    Staff saveStaff(Staff staff);

    void deleteStaff(Long id);

   

}
