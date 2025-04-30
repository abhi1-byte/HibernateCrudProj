package com.zeroesones.service;

import com.zeroesones.dto.Student;

public interface IStudentService {
    public Integer addStudent(String sname,Integer sage,String saddress);
    public Student searchStudent(Integer sid);
    public Integer updateStudent(Integer sid,String sname,Integer sage,String saddress);
    public Integer deleteStudent(Integer sid);
}
