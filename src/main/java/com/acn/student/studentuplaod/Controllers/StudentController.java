package com.acn.student.studentuplaod.Controllers;


import com.acn.student.studentuplaod.Models.Student;
import com.acn.student.studentuplaod.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping(value = "/upload",consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadStudents(@RequestPart("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(studentService.uploadStudents(file));
    }
}
