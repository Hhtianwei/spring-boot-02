package com.training.springboot.impl;

import com.training.springboot.model.StudentModel;
import com.training.springboot.repository.StudentRepository;
import com.training.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2017/12/25.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository stuRepository;

    @Override
    public StudentModel add(StudentModel model) {
        return stuRepository.save(model);
    }

    @Override
    public StudentModel update(StudentModel model) {
        return stuRepository.save(model);
    }

    @Override
    public void delete(StudentModel model) {
        stuRepository.delete(model);
    }

    @Override
    public void delete(Integer id) {
        stuRepository.delete(id);
    }

    @Override
    public StudentModel findById(Integer id) {
        return stuRepository.findOne(id);
    }

    @Override
    public List<StudentModel> findAll() {
        return (List<StudentModel>) stuRepository.findAll();
    }

    @Override
    public List<StudentModel> findByName(String name) {
        return stuRepository.findByName(name);
    }
}
