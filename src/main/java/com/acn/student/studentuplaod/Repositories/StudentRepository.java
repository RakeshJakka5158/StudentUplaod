package com.acn.student.studentuplaod.Repositories;

import com.acn.student.studentuplaod.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
