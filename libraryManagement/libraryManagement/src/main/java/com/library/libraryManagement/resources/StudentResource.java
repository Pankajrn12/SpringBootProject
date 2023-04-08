package com.library.libraryManagement.resources;

import com.library.libraryManagement.models.StudentModel;
import com.library.libraryManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/libraryManagement")
public class StudentResource {
    @Autowired
    StudentService studentService;

    @PostMapping("/saveStudentDetails")
    public ResponseEntity saveStudentDetails(@RequestBody StudentModel model){
       return studentService.saveStudentDetails(model);
    }
    @GetMapping("/getAllStudentDetails")
    public List<StudentModel> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }

    @PostMapping("/deleteStudentById/{studentId}")
    public ResponseEntity deleteStudentById(@PathVariable("studentId") Long studentId){
        return studentService.deleteStudentById(studentId);
    }
    @Transactional

    @PostMapping("/UpdateStudentDetailsById")
    public ResponseEntity UpdateStudentDetailsById(@RequestBody StudentModel studentModel){
        return studentService.UpdateStudentDetailsById(studentModel);
    }

}
