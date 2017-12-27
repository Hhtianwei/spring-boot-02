package com.training.springboot.repository;

import com.training.springboot.model.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/12/25.
 */
@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Integer> {

    List<StudentModel> findByName(String name);

}
