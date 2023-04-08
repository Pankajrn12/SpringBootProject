package com.hospital.hospitalmanagementsystem.resources;

import com.hospital.hospitalmanagementsystem.models.DepartmentModel;
import com.hospital.hospitalmanagementsystem.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class DepartmentResource {
    @Autowired
    DepartmentService departmentService;
    @Transactional
    @PostMapping("/saveDepartmentAllDetails")
    public ResponseEntity saveDepartmentAllDetails(@RequestBody DepartmentModel departmentModel){
        return departmentService.saveDepartmentAllDetails(departmentModel);
    }
    @Transactional
    @PostMapping("/updateDepartmentById")
    public ResponseEntity updateDepartmentById(@RequestBody DepartmentModel departmentModel){
        return departmentService.updateDepartmentById(departmentModel);
    }
    @PostMapping("/deleteDepartmentById/{departmentId}")
    public ResponseEntity deleteDepartmentById(@PathVariable ("departmentId") Long departmentId){
        return departmentService.deleteDepartmentById(departmentId);
    }
    @GetMapping("/getDepartmentDetails")
    public List<DepartmentModel>getDepartmentDetails(){
        return departmentService.getDepartmentDetails();
    }
}
