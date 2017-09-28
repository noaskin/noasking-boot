package com.noasking.es.model;

import java.io.Serializable;

/**
 * Created by MaJing on 2017/9/25.
 */
public class Tutorial implements Serializable {

    private Long id;
    private String name;//教程名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
