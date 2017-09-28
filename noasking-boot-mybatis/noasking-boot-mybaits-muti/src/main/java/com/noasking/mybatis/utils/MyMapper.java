package com.noasking.mybatis.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的BaseDao
 * 特别注意，该接口不能被扫描到，否则会出错
 * Created by MaJing on 2017/8/22.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
