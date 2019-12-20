package com.hxcf.analysis.tests.mapper;

import com.hxcf.analysis.mapper.pre.UserMapper;
import com.hxcf.analysis.mapper.wealth.AdvertPlaceMapper;
import com.hxcf.analysis.model.pre.User;
import com.hxcf.analysis.model.wealth.AdvertPlace;
import com.hxcf.analysis.tests.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

public class TestMapper extends TestBase {
    @Resource
    private UserMapper userMapper;
    @Resource
    private AdvertPlaceMapper advertPlaceMapper;

    @Test
    public void testTwoMapper(){
        User user = userMapper.selectByPrimaryKey(1);
        print(user);
        AdvertPlace advertPlace = advertPlaceMapper.selectByPrimaryKey(1);
        print(advertPlace);
    }
}
