package com.data.service;

import com.data.entity.Student;

import java.util.List;

public interface StudentService {


    Student save(Student student);

    List<Student> getAll();

    Student update(int id,Student newStd);

}
