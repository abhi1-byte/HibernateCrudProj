package com.zeroesones.service;

import com.zeroesones.dto.Student;

public interface IStudentService {
    public Integer save(Student s);

    public Student getById(Integer sid);

    public Integer updateById(Student s);

    public Integer deleteById(Integer sid);
}
