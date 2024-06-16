package com.example.qrcodedemo.repo;

import com.example.qrcodedemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudRepo extends JpaRepository<Student, Long>
{
    Student findByQrcode(String qrcode);
}
