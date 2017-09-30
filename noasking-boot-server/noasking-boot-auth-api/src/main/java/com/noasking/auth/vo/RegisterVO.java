package com.noasking.auth.vo;

import lombok.Data;

/**
 * Created by MaJing on 2017/9/30.
 */
@Data
public class RegisterVO extends UserVO {

    private boolean terms;

    private String fullName;


}
