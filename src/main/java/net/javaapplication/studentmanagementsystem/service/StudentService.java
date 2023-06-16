package net.javaapplication.studentmanagementsystem.service;

import net.javaapplication.studentmanagementsystem.entity.Student;

import java.util.List;


public interface StudentService  {
List<Student> getAllStudents();

 Student saveStudent(Student student);

 Student getstudentbyId(Long id);

 Student updateStudent(Student student);

 // Student deleteById(Long id);

 void deleteById(Long id);


 void findById(Long id);


}
