package com.training.springboot.form;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/12/27.
 */
public class StudentForm {
    private Integer id;

       private String name;
    private String clazz;

    private List<Location> locations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
