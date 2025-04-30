package com.zeroesones.dataaccess;

import com.zeroesones.dto.Student;

public interface IStudentDao {
    public Integer addStudent(String sname,Integer sage,String saddress);
    public Student searchStudent(Integer sid);
    public Integer updateStudent(Integer sid,String sname,Integer sage,String saddress);
    public Integer deleteStudent(Integer sid);
}
