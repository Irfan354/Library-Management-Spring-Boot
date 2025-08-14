package com.library.library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_management_system.entity.Staff;
import com.library.library_management_system.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public List<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }

    @PostMapping
    public Staff addStaff(@RequestBody Staff staff){
        return staffService.saveStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff staff){
        staff.setStaffId(id);   //set the id before saving
        return staffService.saveStaff(staff);
    }

    // @DeleteMapping("/{id}")
    // public void deleteStaff(@PathVariable Long id){
    //      staffService.deleteStaff(id);
    // } 

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteStaff(@PathVariable Long id) {
    try {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    } catch (EmptyResultDataAccessException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        e.printStackTrace(); // log to console
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting staff: " + e.getMessage());
    }
}

}
