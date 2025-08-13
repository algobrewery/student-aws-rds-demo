package org.example.serviceImpl;

//package com.example.studentcrudaws.service.impl;
import org.example.entity.Student;
//import org.example.StudentRepository;
//import com.example.entity.Student;
//import com.example.studentcrudaws.repository.StudentRepository;
//import com.example.studentcrudaws.service.StudentService;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private org.example.repository.StudentRepository studentRepository; // yes, @Autowired is correct here

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return studentRepository.findById(id)
                .map(existing -> {
                    existing.setName(student.getName());
                    existing.setAge(student.getAge());
                    return studentRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
