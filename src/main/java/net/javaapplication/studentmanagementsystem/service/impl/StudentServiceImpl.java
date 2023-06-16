package net.javaapplication.studentmanagementsystem.service.impl;

import net.javaapplication.studentmanagementsystem.entity.Student;
import net.javaapplication.studentmanagementsystem.repository.StudentRepository;
import net.javaapplication.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public  StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        //TODO Auto-generated method stub
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    private Student saveStudent() {
        return saveStudent();
    }

    @Override
    public Student getstudentbyId(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }



    @Override
    public void findById(Long id) {

    }



@Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);

    }

}
