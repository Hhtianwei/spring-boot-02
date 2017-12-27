package com.training.springboot.service;

import com.training.springboot.model.StudentModel;

import java.util.List;

/**
 * Created by lenovo on 2017/12/25.
 */
public interface StudentService {

    StudentModel add(StudentModel model);

    StudentModel update(StudentModel model);

    void delete(StudentModel model);

    void delete(Integer id);

    StudentModel findById(Integer id);

    List<StudentModel> findAll();

    List<StudentModel> findByName(String name);

}
