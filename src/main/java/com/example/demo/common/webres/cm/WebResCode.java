package com.example.demo.common.webres.cm;

import com.example.demo.common.webres.common.CodeMessage;

/**
 * Author: ZhangXiao
 * Created: 2017/6/26
 */
public final class WebResCode {

    /**
     * 前端
     */
    public static final CodeMessage Invalid_Parameter = new CodeMessage("4000", "无效请求参数");
    public static final CodeMessage App_Token_Failed = new CodeMessage("4001", "无效请求令牌");
    public static final CodeMessage Invalid_File_Type = new CodeMessage("1003", "文件格式无效");


    /**
     * 服务器
     */
    public static final CodeMessage Server_Handle_Successful = new CodeMessage("200", "成功");
    public static final CodeMessage Server_Inner_Error = new CodeMessage("500", "服务内部异常");

    /**
     * 后台
     */
    public static final CodeMessage Session_Invalid = new CodeMessage("5008", "登录失效");
    public static final CodeMessage About_Us_Type_Existence = new CodeMessage("5009", "请勿重复添加");
    public static final CodeMessage REQUIRED_FIELD_CANNOT_BE_EMPTY = new CodeMessage("5010", "必填项为空");

    /**
     * restApi
     */

    public static final CodeMessage Electric_Not_Enable = new CodeMessage("6000", "电力平台未启用");
    public static final CodeMessage Huaxia_Not_Enable = new CodeMessage("6001", "华夏未启用");
    public static final CodeMessage Ykt_Not_Enable = new CodeMessage("6002", "一卡通平台未启用");
    public static final CodeMessage Time_Limit = new CodeMessage("6003", "十分钟内不可重复购电");
    public static final CodeMessage UPDATE_WRITE_FAILED = new CodeMessage("6004","写卡通知失败，请稍后再试");
    public static final CodeMessage PLEASE_CALL_REWRITE_CARD = new CodeMessage("6005","请调用补写卡接口");

}