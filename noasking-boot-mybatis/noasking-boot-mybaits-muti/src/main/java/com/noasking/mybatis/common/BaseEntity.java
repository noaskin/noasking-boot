package com.noasking.mybatis.common;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MaJing on 2017/8/22.
 */
@Entity
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
