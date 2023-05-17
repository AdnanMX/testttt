package com.protonema.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.protonema.restapi.entity.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE t_student SET full_name=:fullName WHERE student_id=:id", nativeQuery = true)
    public void updateFullName(@Param("fullName") String fullName, @Param("id") Long id);
}
