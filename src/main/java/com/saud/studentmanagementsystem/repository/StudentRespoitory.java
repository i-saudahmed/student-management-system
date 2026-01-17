package com.saud.studentmanagementsystem.repository;

import com.saud.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespoitory extends JpaRepository<Student, Long> {
}
