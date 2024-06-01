package com.acn.student.studentuplaod.Services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StudentService {
    public int uploadStudents(MultipartFile file) throws IOException;
}
