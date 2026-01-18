package com.saud.studentmanagementsystem;

import com.saud.studentmanagementsystem.entity.Student;
import com.saud.studentmanagementsystem.repository.StudentRespoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagementSystemApplication  {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    //    @Autowired
//    private StudentRespoitory studentRespoitory;
//    @Override
   /* public void run(String... args) throws Exception {


    }*/
//

    @Bean
    CommandLineRunner run(StudentRespoitory studentRespoitory) {
        return args -> {
//            studentRespoitory.deleteAll();

            if (studentRespoitory.count()==0) {
                Student student1 = new Student("Rajesh", "Kumar", "rajesh@gmail.com");
                studentRespoitory.save(student1);

                Student student2 = new Student("Dan", "Joe", "danjoe@gmail.com");
                studentRespoitory.save(student2);
            }
        };
    }
}
