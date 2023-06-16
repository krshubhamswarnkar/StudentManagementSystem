package net.javaapplication.studentmanagementsystem.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name="students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name= "last_name")
    private String lastName;

    @Column(name= "email")
    private String email;

    public Student() {

    }
    public Student(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }
}
