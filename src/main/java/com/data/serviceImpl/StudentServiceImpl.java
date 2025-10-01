package com.data.serviceImpl;

import com.data.entity.Student;
import com.data.repository.StudentRepo;
import com.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student save(Student student) {
        Student student1=studentRepo.save(student);
        return student1;
    }
}
