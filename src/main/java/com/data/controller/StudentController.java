package com.data.controller;

import com.data.entity.Student;
import com.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        Student student1=studentService.save(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> stdList=studentService.getAll();
        return new ResponseEntity<>(stdList,HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        Student student1=studentService.update(id,student);
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
        String msg=studentService.deleteStdById(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }



    @GetMapping("/GetById/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") int id){
       Student student= studentService.getById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);

    }

}
