package com.workorder.controller;

import com.workorder.entity.WosUser;
import com.workorder.service.WosUserService;
import com.workorder.utils.AntiSqlInjection;
import com.workorder.utils.NetworkUtil;
import com.workorder.utils.TokenUtils;
import com.workorder.utils.redis.RedisUtil;
import com.workorder.utils.result.JsonResult;
import com.workorder.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 *  LoginController 登录相关接口
 * </p>
 *
 * @author liuguofeng
 * @since 2021-01-23
 */
@Controller
@ResponseBody
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private WosUserService wosUserService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/tokenLogin")
    public JsonResult tokenLogin(String username, String password, HttpServletRequest request){
        if(StringUtils.isEmpty(username)){
            return ResultCode.error("用户名不能为空");
        }
        if(StringUtils.isEmpty(password)){
            return ResultCode.error("用户名不能为空");
        }
        if(username.length() < 4){
            return ResultCode.error("用户名的长度不合法");
        }
        if(password.length() < 4){
            return ResultCode.error("用户名的长度不合法");
        }
        //经过防sql注入处理
        String user = AntiSqlInjection.filter(username);
        //验证登录信息（true：登录成功，false：失败）
        boolean verifyUser = wosUserService.verifyUser(user, password);
        //登录失败
        if(!verifyUser){
            return ResultCode.error("密码或用户名错误");
        }else {//执行登录
            //用户信息
            WosUser userInfo = wosUserService.getUserInfo(user);
            //获取ip
            String ip = NetworkUtil.getIpAddress(request);
            //获取token
            String token = TokenUtils.token(user,password, ip);
            //在redis中添加数据
            boolean setToken = redisUtil.set(token, userInfo,60*60*24*7);

            //修改用户信息
            userInfo.setLoginCount(userInfo.getLoginCount() + 1);
            userInfo.setLastVisit(new Date());
            if(!setToken || !wosUserService.updateUserById(userInfo)){
                return ResultCode.error("登录失败");
            }
            return ResultCode.success("获取成功",token);
        }
    }
}
