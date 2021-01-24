package com.workorder.service;

import com.workorder.entity.WosUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuguofeng
 * @since 2021-01-23
 */
public interface WosUserService extends IService<WosUser> {
    /**
     * 验证密码和用户名是否正确
     * @param username 用户名
     * @param password 密码
     * @return
     */
    boolean verifyUser(String username,String password);

    /**
     * 根据用户名获取信息
     * @param username 用户名
     * @return
     */
    WosUser getUserInfo(String username);

    /**
     * 根据用户名获取信息
     * @param id 用户唯一标识
     * @return
     */
    WosUser getUserInfo(long id);

    /**
     * 修改用户
     * @param userInfo
     * @return
     */
    boolean updateUserById(WosUser userInfo);
}
