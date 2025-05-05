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
    public Integer save(Student s) {
        return studentDao.save(s);
    }

    @Override
    public Student getById(Integer sid) {
        Student std = studentDao.getById(sid);
        return std;
    }

    @Override
    public Integer updateById(Student s) {
        Integer status = studentDao.updateById(s);
        return status;
    }

    @Override
    public Integer deleteById(Integer sid) {
        Integer i = studentDao.deleteById(sid);
        return i;
    }
}
