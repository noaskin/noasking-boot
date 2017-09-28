package com.noasking.mybatis.service;

import com.noasking.mybatis.dao.SysAdminUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MaJing on 2017/8/22.
 */
@Service
public class UserService{

    @Autowired
    private SysAdminUserDao sysAdminUserDao;

    public int get(){
        return sysAdminUserDao.selectAll().size();
    }


}
