package com.training.springboot.web;

import com.training.springboot.form.StudentForm;
import com.training.springboot.model.StudentModel;
import com.training.springboot.result.Result;
import com.training.springboot.result.ResultUtil;
import com.training.springboot.service.StudentService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/12/25.
 */
@RestController
@RequestMapping("/stu")
public class StudentController {

    protected final StudentService stuService;

    public StudentController(StudentService stuService) {
        this.stuService = stuService;
    }

    @GetMapping(value="/query/{id}")
    public Result<StudentModel> queryById(@PathVariable("id") Integer id){
        return ResultUtil.success(stuService.findById(id));
    }

    @GetMapping("/queryByName/{name}")
    public Result queryByName(@PathVariable("name") String name){
        return ResultUtil.success(stuService.findByName(name));
    }

    @GetMapping(value="/queryAll")
    public Result queryAll(){
        return ResultUtil.success(stuService.findAll());
    }

    @PostMapping("/add")
    public Result add(@RequestParam("name") String name,
                      @RequestParam("clazz") String clazz){
        StudentModel model = new StudentModel();
        model.setName(name);
        model.setClazz(clazz);
        model.setCreateTime(new Date());
        model.setUpdateTime(new Date());
        return ResultUtil.success(stuService.add(model));
    }

    @DeleteMapping(value="/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        stuService.delete(id);
        return ResultUtil.success();
    }

}
