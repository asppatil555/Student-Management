package com.data.serviceImpl;

import com.data.entity.Student;
import com.data.repository.StudentRepo;
import com.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student save(Student student) {
        Student student1=studentRepo.save(student);
        return student1;
    }

    @Override
    public List<Student> getAll() {
        List<Student> stdList=studentRepo.findAll();
        return stdList;
    }

    @Override
    public Student update(int id,Student newStd) {
        Student student=studentRepo.findById(id).orElseThrow(()->new NullPointerException("id does not found"));
        student.setFName(newStd.getFName());
        student.setLName(newStd.getLName());
        Student updateStudent=studentRepo.save(student);

        return updateStudent;
    }

    @Override
    public String deleteStdById(int id) {
        studentRepo.deleteById(id);
        return "Student Delete";
    }


}
