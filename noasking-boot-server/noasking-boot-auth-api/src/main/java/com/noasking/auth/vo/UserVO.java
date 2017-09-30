package com.noasking.auth.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by MaJing on 2017/9/30.
 */
@Data
public class UserVO {

    @NotBlank(message = "不能为空")
    private String email;

    @NotBlank(message = "不能为空")
    private String password;

}
