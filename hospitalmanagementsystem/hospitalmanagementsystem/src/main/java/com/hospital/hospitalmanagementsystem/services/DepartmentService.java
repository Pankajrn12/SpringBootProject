package com.hospital.hospitalmanagementsystem.services;

import com.hospital.hospitalmanagementsystem.entities.Department;
import com.hospital.hospitalmanagementsystem.models.DepartmentModel;
import com.hospital.hospitalmanagementsystem.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EntityManager entityManager;

    public ResponseEntity saveDepartmentAllDetails(DepartmentModel departmentModel) {
        Department department = new Department();
        department.setDepartmentName(departmentModel.getDepartmentName());
        department.setDepartmentDcription(departmentModel.getDepartmentDcription());
        departmentRepository.save(department);
        return new ResponseEntity<>("Saved Data ", HttpStatus.OK);
    }

    public ResponseEntity updateDepartmentById(DepartmentModel departmentModel) {
        entityManager.createNativeQuery("update department set department_dcription =:department_dcription , department_name =:department_name where department_id =:department_id ")
                .setParameter("department_dcription",departmentModel.getDepartmentDcription())
                .setParameter("department_name",departmentModel.getDepartmentName())
                .setParameter("department_id",departmentModel.getDepartmentId()).executeUpdate();
        return new ResponseEntity<>("Updated Data", HttpStatus.OK);
    }

    public ResponseEntity deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return new ResponseEntity<>("Data Deleted",HttpStatus.OK);
    }

    public List<DepartmentModel> getDepartmentDetails() {
        List<DepartmentModel>departmentModelList= new ArrayList<>();
        List<Department>departmentList = departmentRepository.findAll();
        departmentList.stream().forEach(data->{
            DepartmentModel model = new DepartmentModel();
            model.setDepartmentId(data.getDepartmentId());
            model.setDepartmentName(data.getDepartmentName());
            model.setDepartmentDcription(data.getDepartmentDcription());

            departmentModelList.add(model);
        });
        return departmentModelList;
    }
}
