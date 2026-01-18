package com.saud.studentmanagementsystem.service.impl;

import com.saud.studentmanagementsystem.entity.Student;
import com.saud.studentmanagementsystem.repository.StudentRespoitory;
import com.saud.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRespoitory studentRespoitory;

    @Autowired
    public StudentServiceImpl(StudentRespoitory studentRespoitory) {
        this.studentRespoitory = studentRespoitory;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRespoitory.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRespoitory.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRespoitory.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRespoitory.save(student);
    }
}
