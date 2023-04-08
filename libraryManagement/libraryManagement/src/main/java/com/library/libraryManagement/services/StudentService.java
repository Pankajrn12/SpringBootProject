package com.library.libraryManagement.services;

import com.library.libraryManagement.entities.Student;
import com.library.libraryManagement.models.StudentModel;
import com.library.libraryManagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EntityManager em;
    @Transactional
    public ResponseEntity saveStudentDetails(StudentModel model) {
        Student student = new Student();
        student.setStudentFirstName(model.getStudentFirstName());
        student.setStudentLastName(model.getStudentLastName());
        student.setStudentEmail(model.getStudentEmail());
        student.setStudentContact(model.getStudentContact());
        student.setStudentAddress(model.getStudentAddress());

        studentRepository.save(student);
        return new ResponseEntity<>("data is saved", HttpStatus.OK);
    }

    public List<StudentModel> getAllStudentDetails() {
        List<StudentModel> modelList = new ArrayList<>();
        List<Student> list = studentRepository.findAll();
        list.stream().forEach(data->{
            StudentModel model = new StudentModel();
            model.setStudentId(data.getStudentId());
            model.setStudentFirstName(data.getStudentFirstName());
            model.setStudentLastName(data.getStudentLastName());
            model.setStudentEmail(data.getStudentEmail());
            model.setStudentContact(data.getStudentContact());
            model.setStudentAddress(data.getStudentAddress());
            modelList.add(model);
        });
        return modelList;
    }

    public ResponseEntity deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
        return new ResponseEntity<>("data is deleted", HttpStatus.OK);
    }

    public ResponseEntity UpdateStudentDetailsById(StudentModel studentModel) {
        em.createNativeQuery("update student set student_first_name =:firstName, student_last_name =:lastName, student_email =:email, student_contact =:contact where\n" +
                "student_id =:studentId ")
                .setParameter("firstName", studentModel.getStudentFirstName())
                .setParameter("lastName", studentModel.getStudentLastName())
                .setParameter("email", studentModel.getStudentEmail())
                .setParameter("contact", studentModel.getStudentContact())
                .setParameter("studentId", studentModel.getStudentId()).executeUpdate();
        return new ResponseEntity<>("data is updated", HttpStatus.OK);
    }
}
