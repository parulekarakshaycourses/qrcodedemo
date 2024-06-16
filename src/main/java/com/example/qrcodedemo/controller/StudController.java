package com.example.qrcodedemo.controller;

import com.example.qrcodedemo.entity.Student;
import com.example.qrcodedemo.repo.StudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

@Controller
public class StudController
{
    @Autowired
    StudRepo studRepo;

    @GetMapping("/stud/reg/")
    public String studReg()
    {
        return "studReg";
    }

    @GetMapping("/stud/info/")
    public String studInfo()
    {
        return "studInfo";
    }


    @PostMapping("/stud/save/")
    @ResponseBody
    public Integer saveStudent(@RequestBody Student stud)
    {
        System.out.println("student = " + stud.toString());

        try
        {
            studRepo.save(stud);
        }
        catch(Exception ex)
        {
            return 2;
        }

        return 1;
    }

    @PostMapping("/stud/find/")
    @ResponseBody
    public Student findStudent(String qrcode)
    {
        return studRepo.findByQrcode(qrcode);
    }
}
