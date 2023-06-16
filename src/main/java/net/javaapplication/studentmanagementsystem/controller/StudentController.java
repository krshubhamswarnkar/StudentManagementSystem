package net.javaapplication.studentmanagementsystem.controller;

import net.javaapplication.studentmanagementsystem.entity.Student;
import net.javaapplication.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
       System.out.println();
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
         studentService.saveStudent(student);
        return "redirect:/students";

    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getstudentbyId(id));
        return "edit_student";

    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
        @ModelAttribute("student") Student student, Model model) {

        //get student from databases by id

        Student existingStudent = studentService.getstudentbyId(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //Save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";


    }
    //handler method to handle delete student request

    public String getStudent(@PathVariable Long id) {
        studentService.findById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/students";

    }

}

