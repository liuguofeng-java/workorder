package com.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.workorder.entity.WosUser;
import com.workorder.dao.WosUserMapper;
import com.workorder.service.WosUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.workorder.utils.AntiSqlInjection;
import com.workorder.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuguofeng
 * @since 2021-01-23
 */
@Service
public class WosUserServiceImpl extends ServiceImpl<WosUserMapper, WosUser> implements WosUserService {

    @Autowired
    private WosUserMapper wosUserMapper;

    @Override
    public boolean verifyUser(String username, String password) {
        QueryWrapper<WosUser> wrapper = new QueryWrapper<>();
        wrapper.eq("UserName",username);
        WosUser wosUser = wosUserMapper.selectOne(wrapper);//找出用户输入的用户名
        //如果找不到用户则返回false
        if(wosUser == null){
            return false;
        }
        //用户输入的密码加密
        String passMd5 = Md5Util.MD5Lower(password, wosUser.getSalt());
        if(!passMd5.equals(wosUser.getPassword())){
            return false;
        }
        return true;
    }

    @Override
    public WosUser getUserInfo(String username) {
        QueryWrapper<WosUser> wrapper = new QueryWrapper<>();
        wrapper.eq("UserName",username);
        return wosUserMapper.selectOne(wrapper);
    }

    @Override
    public WosUser getUserInfo(long id) {
        QueryWrapper<WosUser> wrapper = new QueryWrapper<>();
        wrapper.eq("Id",id);
        return wosUserMapper.selectOne(wrapper);
    }

    @Override
    public boolean updateUserById(WosUser userInfo) {
        return wosUserMapper.updateById(userInfo) > 0;
    }
}
