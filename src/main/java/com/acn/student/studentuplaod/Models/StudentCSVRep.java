package com.acn.student.studentuplaod.Models;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCSVRep {
    @CsvBindByName(column = "firstName")
    private String fName;
    @CsvBindByName(column = "lastName")
    private String lName;
    @CsvBindByName(column = "age")
    private int age;
    @CsvBindByName(column = "contactNum")
    private String phnNum;

}
