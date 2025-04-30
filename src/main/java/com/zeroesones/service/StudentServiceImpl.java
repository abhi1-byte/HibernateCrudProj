package com.zeroesones.service;

import com.zeroesones.daofactory.StudentDaoFactory;
import com.zeroesones.dataaccess.IStudentDao;
import com.zeroesones.dto.Student;

//Service Layer
public class StudentServiceImpl implements IStudentService {
    static IStudentDao studentDao;

    static {
        studentDao = StudentDaoFactory.getStudentDao();
    }

    @Override
    public Integer addStudent(String sname, Integer sage, String saddress) {
        return studentDao.addStudent(sname, sage, saddress);
    }

    @Override
    public Student searchStudent(Integer sid) {
        Student std = studentDao.searchStudent(sid);
        return std;
    }

    @Override
    public Integer updateStudent(Integer sid, String sname, Integer sage, String saddress) {
        Integer status = studentDao.updateStudent(sid, sname, sage, saddress);
        return status;
    }

    @Override
    public Integer deleteStudent(Integer sid) {
        Integer i =studentDao.deleteStudent(sid);
        return i;
    }
}
