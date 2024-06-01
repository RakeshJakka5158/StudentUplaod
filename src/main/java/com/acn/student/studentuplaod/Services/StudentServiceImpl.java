package com.acn.student.studentuplaod.Services;

import com.acn.student.studentuplaod.Models.Student;
import com.acn.student.studentuplaod.Models.StudentCSVRep;
import com.acn.student.studentuplaod.Repositories.StudentRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public int uploadStudents(MultipartFile file) throws IOException {
        List<Student> students = parseCSV(file);
        studentRepository.saveAll(students);
        return students.size();
    }

    private List<Student> parseCSV(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<StudentCSVRep> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(StudentCSVRep.class);
            CsvToBean<StudentCSVRep> csvToBean = new CsvToBeanBuilder<StudentCSVRep>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse().stream().map(csvLine -> Student.builder()
                    .firstName(csvLine.getFName())
                    .lastName(csvLine.getLName())
                    .age(csvLine.getAge())
                    .contactNum(csvLine.getPhnNum())
                    .build()).toList();

        }
    }
}
