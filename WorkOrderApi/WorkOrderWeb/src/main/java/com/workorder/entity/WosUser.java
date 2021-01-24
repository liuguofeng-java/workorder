package com.workorder.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuguofeng
 * @since 2021-01-23
 */
@Data
@TableName("WosUser")
public class WosUser implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "Id", type = IdType.INPUT)
    private Long Id;

    /**
     * 用户名
     */
    @TableField("UserName")
    private String UserName;

    /**
     * 密码
     */
    @TableField("Password")
    private String Password;

    /**
     * 密码盐值
     */
    @TableField("Salt")
    private String Salt;

    /**
     * 姓名
     */
    @TableField("RealName")
    private String RealName;

    /**
     * 所属部门Id
     */
    @TableField("DepartmentId")
    private Long DepartmentId;

    /**
     * 性别(0未知 1男 2女)
     */
    @TableField("Gender")
    private Integer Gender;

    /**
     * 出生日期
     */
    @TableField("Birthday")
    private String Birthday;

    /**
     * 头像
     */
    @TableField("Portrait")
    private String Portrait;

    /**
     * Email
     */
    @TableField("Email")
    private String Email;

    /**
     * 手机
     */
    @TableField("Mobile")
    private String Mobile;

    /**
     * QQ
     */
    @TableField("QQ")
    private String qq;

    /**
     * 微信
     */
    @TableField("WeChat")
    private String WeChat;

    /**
     * 登录次数
     */
    @TableField("LoginCount")
    private Integer LoginCount;

    /**
     * 用户状态(0禁用 1启用)
     */
    @TableField("UserStatus")
    private Integer UserStatus;

    /**
     * 系统用户(0不是 1是[系统用户拥有所有的权限])
     */
    @TableField("IsSystem")
    private Integer IsSystem;

    /**
     * 在线(0不是 1是)
     */
    @TableField("IsOnline")
    private Integer IsOnline;

    /**
     * 首次登录时间
     */
    @TableField("FirstVisit")
    private Date FirstVisit;

    /**
     * 上一次登录时间
     */
    @TableField("PreviousVisit")
    private Date PreviousVisit;

    /**
     * 最后一次登录时间
     */
    @TableField("LastVisit")
    private Date LastVisit;

    /**
     * 备注
     */
    @TableField("Remark")
    private String Remark;




    @Override
    public String toString() {
        return "WosUser{" +
        "Id=" + Id +
        ", UserName=" + UserName +
        ", Password=" + Password +
        ", Salt=" + Salt +
        ", RealName=" + RealName +
        ", DepartmentId=" + DepartmentId +
        ", Gender=" + Gender +
        ", Birthday=" + Birthday +
        ", Portrait=" + Portrait +
        ", Email=" + Email +
        ", Mobile=" + Mobile +
        ", qq=" + qq +
        ", WeChat=" + WeChat +
        ", LoginCount=" + LoginCount +
        ", UserStatus=" + UserStatus +
        ", IsSystem=" + IsSystem +
        ", IsOnline=" + IsOnline +
        ", FirstVisit=" + FirstVisit +
        ", PreviousVisit=" + PreviousVisit +
        ", LastVisit=" + LastVisit +
        ", Remark=" + Remark +
        "}";
    }
}
