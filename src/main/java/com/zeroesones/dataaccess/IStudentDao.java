package com.zeroesones.dataaccess;

import com.zeroesones.dto.Student;

public interface IStudentDao {
    public Integer save(Student s);

    public Student getById(Integer sid);

    public Integer updateById(Student s);

    public Integer deleteById(Integer sid);
}
