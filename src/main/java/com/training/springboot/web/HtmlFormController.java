package com.training.springboot.web;

import com.training.springboot.form.StudentForm;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by lenovo on 2017/12/27.
 */

@Controller
@RequestMapping("/form")
public class HtmlFormController {

    @RequestMapping
    public String student(Model model){
        model.addAttribute("date",new Date());
        return "student";
    }

    @RequestMapping(value="/addStu",method = RequestMethod.POST)
    @ResponseBody
    public String addStu(@RequestBody StudentForm form){

        System.out.println("form:" + ReflectionToStringBuilder.toString(form));
        return "success:"+ReflectionToStringBuilder.toString(form);
    }

    @RequestMapping(value="/addStu2",method = RequestMethod.POST)
    @ResponseBody
    public String addStu2(StudentForm form){

        System.out.println("form:" + ReflectionToStringBuilder.toString(form));
        return ReflectionToStringBuilder.toString(form);
    }

}
