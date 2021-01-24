package com.workorder;

import com.workorder.dao.WosUserMapper;
import com.workorder.service.WosUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginTest {
    @Autowired
    private WosUserService wosUserService;

    @Autowired
    private WosUserMapper wosUserMapper;
    @Test
    public void test1(){
        boolean b = wosUserService.verifyUser("liuguofeng", "lbf123");
        System.out.println(b);


    }
}
