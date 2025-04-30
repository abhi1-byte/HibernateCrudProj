package com.zeroesones.servicefactory;

import com.zeroesones.service.IStudentService;
import com.zeroesones.service.StudentServiceImpl;

public class StudentServiceFactory {
    private StudentServiceFactory(){}

    private static IStudentService studentService = null;

    public static IStudentService getStudentService(){
        if(studentService==null) {
            studentService = new StudentServiceImpl();
        }
        return studentService;
    }
}
