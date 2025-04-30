package com.zeroesones.daofactory;

import com.zeroesones.dataaccess.IStudentDao;
import com.zeroesones.dataaccess.StudentDaoImpl;

public class StudentDaoFactory {
    private StudentDaoFactory(){}

    private static IStudentDao studentDao = null;

    public static IStudentDao getStudentDao(){
        if(studentDao == null) {
            studentDao = new StudentDaoImpl();
        }
        return  studentDao;
    }
}
